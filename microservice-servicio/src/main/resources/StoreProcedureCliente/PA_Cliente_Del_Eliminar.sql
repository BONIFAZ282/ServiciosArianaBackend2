
CREATE PROCEDURE PA_Cliente_Del_Eliminar(
    @nClienteId INT
)
AS
BEGIN
    SET NOCOUNT ON
    BEGIN TRY
        BEGIN TRAN
            IF NOT EXISTS (SELECT 1 FROM Cliente WHERE nClienteId = @nClienteId)
            BEGIN
                RAISERROR('El cliente no existe', 16, 1)
                RETURN
            END

            IF EXISTS (SELECT 1 FROM OrdenServicio WHERE nClienteId = @nClienteId)
            BEGIN
                RAISERROR('No se puede eliminar el cliente porque tiene órdenes de servicio asociadas', 16, 1)
                RETURN
            END

            UPDATE Cliente SET bEstado = 0 WHERE nClienteId = @nClienteId
            SELECT @nClienteId AS nClienteId
        COMMIT TRAN
    END TRY
    BEGIN CATCH
        IF @@TRANCOUNT > 0 ROLLBACK TRAN
        DECLARE @ErrorMessage NVARCHAR(4000) = ERROR_MESSAGE()
        RAISERROR(@ErrorMessage, 16, 1)
    END CATCH
END