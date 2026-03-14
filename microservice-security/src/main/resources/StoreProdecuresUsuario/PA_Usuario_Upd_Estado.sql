/*---------------------------------------------------------------------------------
PROPÓSITO           | Activa o desactiva un usuario
AUTOR               | Sibhell Dhaleska
FECHA DE CREACIÓN   | 2025-01-21
-----------------------------------------------------------------------------------
EJEMPLO:
    EXEC PA_Usuario_Upd_Estado 1, 0
-----------------------------------------------------------------------------------*/
CREATE PROCEDURE PA_Usuario_Upd_Estado(
    @nUsuarioId INT,
    @bEstado    BIT
)
AS
BEGIN
    SET NOCOUNT ON
    BEGIN TRY
        BEGIN TRAN
            UPDATE Usuario SET bEstado = @bEstado
            WHERE nUsuarioId = @nUsuarioId

            SELECT @@ROWCOUNT AS nFilasAfectadas
        COMMIT TRAN
    END TRY
    BEGIN CATCH
        IF @@TRANCOUNT > 0
            ROLLBACK TRAN
        DECLARE @ErrorMessage NVARCHAR(4000) = ERROR_MESSAGE()
        DECLARE @ErrorSeverity INT = ERROR_SEVERITY()
        DECLARE @ErrorState INT = ERROR_STATE()
        RAISERROR(@ErrorMessage, @ErrorSeverity, @ErrorState)
    END CATCH
END