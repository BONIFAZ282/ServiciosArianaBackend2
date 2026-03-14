
CREATE PROCEDURE PA_OrdenServicio_Del_Eliminar(
    @nOrdenServicioId INT
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

            DECLARE @cEstadoOrdenCod VARCHAR(20)
            SELECT @cEstadoOrdenCod = eo.cEstadoOrdenCod
            FROM OrdenServicio os
            INNER JOIN EstadoOrden eo ON os.nEstadoOrdenId = eo.nEstadoOrdenId
            WHERE os.nOrdenServicioId = @nOrdenServicioId

            IF @cEstadoOrdenCod != 'PENDIENTE'
            BEGIN
                RAISERROR('Solo se pueden eliminar órdenes en estado Pendiente', 16, 1)
                RETURN
            END

            UPDATE OrdenServicio SET bEstado = 0 WHERE nOrdenServicioId = @nOrdenServicioId
            SELECT @nOrdenServicioId AS nOrdenServicioId
        COMMIT TRAN
    END TRY
    BEGIN CATCH
        IF @@TRANCOUNT > 0 ROLLBACK TRAN
        DECLARE @ErrorMessage NVARCHAR(4000) = ERROR_MESSAGE()
        RAISERROR(@ErrorMessage, 16, 1)
    END CATCH
END