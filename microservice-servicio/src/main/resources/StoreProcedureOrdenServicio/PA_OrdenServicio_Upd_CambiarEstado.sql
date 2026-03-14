
CREATE PROCEDURE PA_OrdenServicio_Upd_CambiarEstado(
    @nOrdenServicioId       INT,
    @cEstadoOrdenCodNuevo   VARCHAR(20),
    @cComentario            VARCHAR(500),
    @nUsuarioId             INT
)
AS
BEGIN
    SET NOCOUNT ON
    BEGIN TRY
        BEGIN TRAN
            IF NOT EXISTS (SELECT 1 FROM OrdenServicio WHERE nOrdenServicioId = @nOrdenServicioId)
            BEGIN
                RAISERROR('La orden de servicio no existe', 16, 1)
                RETURN
            END

            DECLARE @nEstadoOrdenIdActual INT, @cEstadoOrdenCodActual VARCHAR(20)

            SELECT @nEstadoOrdenIdActual = os.nEstadoOrdenId, @cEstadoOrdenCodActual = eo.cEstadoOrdenCod
            FROM OrdenServicio os
            INNER JOIN EstadoOrden eo ON os.nEstadoOrdenId = eo.nEstadoOrdenId
            WHERE os.nOrdenServicioId = @nOrdenServicioId

            DECLARE @nEstadoOrdenIdNuevo INT
            SELECT @nEstadoOrdenIdNuevo = nEstadoOrdenId FROM EstadoOrden WHERE cEstadoOrdenCod = @cEstadoOrdenCodNuevo

            IF @nEstadoOrdenIdNuevo IS NULL
            BEGIN
                RAISERROR('El estado especificado no es válido', 16, 1)
                RETURN
            END

            -- Validar transición
            DECLARE @bTransicionValida BIT = 0

            IF @cEstadoOrdenCodActual = 'PENDIENTE' AND @cEstadoOrdenCodNuevo IN ('EN_PROCESO', 'CANCELADO')
                SET @bTransicionValida = 1
            ELSE IF @cEstadoOrdenCodActual = 'EN_PROCESO' AND @cEstadoOrdenCodNuevo IN ('FINALIZADO', 'CANCELADO')
                SET @bTransicionValida = 1
            ELSE IF @cEstadoOrdenCodActual = 'FINALIZADO' AND @cEstadoOrdenCodNuevo IN ('RESUELTO', 'OBSERVADO')
                SET @bTransicionValida = 1
            ELSE IF @cEstadoOrdenCodActual = 'OBSERVADO' AND @cEstadoOrdenCodNuevo = 'EN_PROCESO'
                SET @bTransicionValida = 1

            IF @bTransicionValida = 0
            BEGIN
                DECLARE @cMensajeError VARCHAR(200) = 'No se permite cambiar de ' + @cEstadoOrdenCodActual + ' a ' + @cEstadoOrdenCodNuevo
                RAISERROR(@cMensajeError, 16, 1)
                RETURN
            END

            UPDATE OrdenServicio SET
                nEstadoOrdenId = @nEstadoOrdenIdNuevo,
                dFechaFinReal = CASE
                    WHEN @cEstadoOrdenCodNuevo IN ('FINALIZADO', 'RESUELTO') THEN CAST(GETDATE() AS DATE)
                    WHEN @cEstadoOrdenCodNuevo = 'OBSERVADO' THEN NULL
                    ELSE dFechaFinReal
                END
            WHERE nOrdenServicioId = @nOrdenServicioId

            INSERT INTO OrdenServicioHistorial (nOrdenServicioId, nEstadoOrdenAnteriorId, nEstadoOrdenNuevoId, cComentario, nUsuarioId)
            VALUES (@nOrdenServicioId, @nEstadoOrdenIdActual, @nEstadoOrdenIdNuevo, @cComentario, @nUsuarioId)

            SELECT @nOrdenServicioId AS nOrdenServicioId, @cEstadoOrdenCodNuevo AS cEstadoOrdenCod
        COMMIT TRAN
    END TRY
    BEGIN CATCH
        IF @@TRANCOUNT > 0 ROLLBACK TRAN
        DECLARE @ErrorMessage NVARCHAR(4000) = ERROR_MESSAGE()
        RAISERROR(@ErrorMessage, 16, 1)
    END CATCH
END