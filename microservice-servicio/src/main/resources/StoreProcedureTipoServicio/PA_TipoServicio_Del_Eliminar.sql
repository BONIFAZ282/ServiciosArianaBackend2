
CREATE PROCEDURE PA_TipoServicio_Del_Eliminar(
    @nTipoServicioId INT
)
AS
BEGIN
    SET NOCOUNT ON
    BEGIN TRY
        BEGIN TRAN
            IF NOT EXISTS (SELECT 1 FROM TipoServicio WHERE nTipoServicioId = @nTipoServicioId)
            BEGIN
                RAISERROR('El tipo de servicio no existe', 16, 1)
                RETURN
            END

            IF EXISTS (SELECT 1 FROM OrdenServicio WHERE nTipoServicioId = @nTipoServicioId)
            BEGIN
                RAISERROR('No se puede eliminar porque tiene órdenes asociadas', 16, 1)
                RETURN
            END

            UPDATE TipoServicio SET bEstado = 0 WHERE nTipoServicioId = @nTipoServicioId
            SELECT @nTipoServicioId AS nTipoServicioId
        COMMIT TRAN
    END TRY
    BEGIN CATCH
        IF @@TRANCOUNT > 0 ROLLBACK TRAN
        DECLARE @ErrorMessage NVARCHAR(4000) = ERROR_MESSAGE()
        RAISERROR(@ErrorMessage, 16, 1)
    END CATCH
END