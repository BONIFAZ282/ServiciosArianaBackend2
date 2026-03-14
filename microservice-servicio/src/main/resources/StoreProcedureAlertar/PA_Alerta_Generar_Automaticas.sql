/*=================================================================================
  PROCEDIMIENTOS ALMACENADOS: Alertas
  AUTOR:         Sibhell Dhaleska
  FECHA:         2025-01-30
===================================================================================*/

/*---------------------------------------------------------------------------------
PROPÓSITO          | Genera alertas automáticas (POR_VENCER y VENCIDO)
NOTA               | Ejecutar diariamente con un Job o manualmente
---------------------------------------------------------------------------------*/
IF OBJECT_ID('PA_Alerta_Generar_Automaticas') IS NOT NULL
    DROP PROCEDURE PA_Alerta_Generar_Automaticas
GO

CREATE PROCEDURE PA_Alerta_Generar_Automaticas
AS
BEGIN
    SET NOCOUNT ON
    BEGIN TRY
        BEGIN TRAN
            DECLARE @nTipoAlertaPorVencer INT, @nTipoAlertaVencido INT
            DECLARE @nAlertasGeneradas INT = 0

            SELECT @nTipoAlertaPorVencer = nTipoAlertaId FROM TipoAlerta WHERE cTipoAlertaCod = 'POR_VENCER'
            SELECT @nTipoAlertaVencido = nTipoAlertaId FROM TipoAlerta WHERE cTipoAlertaCod = 'VENCIDO'

            -- ============================================
            -- 1. ALERTAS POR VENCER
            -- Órdenes que están dentro del umbral de días
            -- ============================================
            INSERT INTO Alerta (nOrdenServicioId, nTipoAlertaId, cMensaje)
            SELECT
                os.nOrdenServicioId,
                @nTipoAlertaPorVencer,
                'La orden ' + os.cOrdenServicioCod + ' está próxima a vencer (' +
                CAST(DATEDIFF(DAY, GETDATE(), os.dFechaFin) AS VARCHAR) + ' días restantes)'
            FROM OrdenServicio os
            INNER JOIN EstadoOrden eo ON os.nEstadoOrdenId = eo.nEstadoOrdenId
            INNER JOIN Prioridad pr ON os.nPrioridadId = pr.nPrioridadId
            WHERE os.bEstado = 1
            AND eo.cEstadoOrdenCod IN ('PENDIENTE', 'EN_PROCESO', 'OBSERVADO')
            AND os.dFechaFin >= CAST(GETDATE() AS DATE)  -- Aún no vence
            AND DATEDIFF(DAY, GETDATE(), os.dFechaFin) <= pr.nDiasAlerta  -- Dentro del umbral
            AND NOT EXISTS (
                -- No generar si ya existe alerta POR_VENCER activa para esta orden
                SELECT 1 FROM Alerta a
                WHERE a.nOrdenServicioId = os.nOrdenServicioId
                AND a.nTipoAlertaId = @nTipoAlertaPorVencer
                AND a.bEstado = 1
                AND CAST(a.dFechaGeneracion AS DATE) = CAST(GETDATE() AS DATE)
            )

            SET @nAlertasGeneradas = @nAlertasGeneradas + @@ROWCOUNT

            -- ============================================
            -- 2. ALERTAS VENCIDAS
            -- Órdenes que ya pasaron su fecha límite
            -- ============================================
            INSERT INTO Alerta (nOrdenServicioId, nTipoAlertaId, cMensaje)
            SELECT
                os.nOrdenServicioId,
                @nTipoAlertaVencido,
                'La orden ' + os.cOrdenServicioCod + ' ha vencido hace ' +
                CAST(DATEDIFF(DAY, os.dFechaFin, GETDATE()) AS VARCHAR) + ' días'
            FROM OrdenServicio os
            INNER JOIN EstadoOrden eo ON os.nEstadoOrdenId = eo.nEstadoOrdenId
            WHERE os.bEstado = 1
            AND eo.cEstadoOrdenCod IN ('PENDIENTE', 'EN_PROCESO', 'OBSERVADO')
            AND os.dFechaFin < CAST(GETDATE() AS DATE)  -- Ya venció
            AND NOT EXISTS (
                -- No generar si ya existe alerta VENCIDO activa para esta orden hoy
                SELECT 1 FROM Alerta a
                WHERE a.nOrdenServicioId = os.nOrdenServicioId
                AND a.nTipoAlertaId = @nTipoAlertaVencido
                AND a.bEstado = 1
                AND CAST(a.dFechaGeneracion AS DATE) = CAST(GETDATE() AS DATE)
            )

            SET @nAlertasGeneradas = @nAlertasGeneradas + @@ROWCOUNT

            SELECT @nAlertasGeneradas AS nAlertasGeneradas
        COMMIT TRAN
    END TRY
    BEGIN CATCH
        IF @@TRANCOUNT > 0 ROLLBACK TRAN
        DECLARE @ErrorMessage NVARCHAR(4000) = ERROR_MESSAGE()
        RAISERROR(@ErrorMessage, 16, 1)
    END CATCH
END