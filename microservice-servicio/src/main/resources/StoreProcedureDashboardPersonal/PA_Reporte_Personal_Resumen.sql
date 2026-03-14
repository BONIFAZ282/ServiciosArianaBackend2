/*=================================================================================
  PROCEDIMIENTOS ALMACENADOS: Reportes Por Trabajador
  AUTOR:         Sibhell Dhaleska
  FECHA:         2025-01-23
===================================================================================*/

/*---------------------------------------------------------------------------------
PROPÓSITO          | Resumen de un trabajador específico
---------------------------------------------------------------------------------*/
IF OBJECT_ID('PA_Reporte_Personal_Resumen') IS NOT NULL
    DROP PROCEDURE PA_Reporte_Personal_Resumen
GO

CREATE PROCEDURE PA_Reporte_Personal_Resumen(
    @nPersonalId INT
)
AS
BEGIN
    SET NOCOUNT ON
    SELECT
        @nPersonalId AS nPersonalId,
        -- Como líder
        (SELECT COUNT(*) FROM OrdenServicio WHERE nPersonalLiderId = @nPersonalId AND bEstado = 1) AS nOrdenesComoLider,
        (SELECT COUNT(*) FROM OrdenServicio os
         INNER JOIN EstadoOrden eo ON os.nEstadoOrdenId = eo.nEstadoOrdenId
         WHERE os.nPersonalLiderId = @nPersonalId AND eo.cEstadoOrdenCod = 'RESUELTO' AND os.bEstado = 1) AS nOrdenesCompletadasComoLider,
        -- Como miembro del equipo
        (SELECT COUNT(DISTINCT nOrdenServicioId) FROM OrdenServicioPersonal WHERE nPersonalId = @nPersonalId AND bActivo = 1) AS nOrdenesComoMiembro,
        -- Activas actualmente
        (SELECT COUNT(*) FROM OrdenServicio os
         INNER JOIN EstadoOrden eo ON os.nEstadoOrdenId = eo.nEstadoOrdenId
         WHERE os.nPersonalLiderId = @nPersonalId
         AND eo.cEstadoOrdenCod IN ('PENDIENTE', 'EN_PROCESO', 'OBSERVADO') AND os.bEstado = 1) AS nOrdenesActivasComoLider,
        (SELECT COUNT(DISTINCT osp.nOrdenServicioId) FROM OrdenServicioPersonal osp
         INNER JOIN OrdenServicio os ON osp.nOrdenServicioId = os.nOrdenServicioId
         INNER JOIN EstadoOrden eo ON os.nEstadoOrdenId = eo.nEstadoOrdenId
         WHERE osp.nPersonalId = @nPersonalId AND osp.bActivo = 1
         AND eo.cEstadoOrdenCod IN ('PENDIENTE', 'EN_PROCESO', 'OBSERVADO') AND os.bEstado = 1) AS nOrdenesActivasComoMiembro,
        -- Subordinados
        (SELECT COUNT(*) FROM Personal WHERE nPersonalLiderId = @nPersonalId AND bEstado = 1) AS nSubordinados
END