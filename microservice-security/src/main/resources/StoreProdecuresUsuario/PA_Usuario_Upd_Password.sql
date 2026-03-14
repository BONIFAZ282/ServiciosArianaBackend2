/*---------------------------------------------------------------------------------
PROPÓSITO           | Actualiza la contraseña del usuario
AUTOR               | Sibhell Dhaleska
FECHA DE CREACIÓN   | 2025-01-21
-----------------------------------------------------------------------------------
EJEMPLO:
    EXEC PA_Usuario_Upd_Password 1, '$2a$10$...'
-----------------------------------------------------------------------------------*/
CREATE PROCEDURE PA_Usuario_Upd_Password(
    @nUsuarioId     INT,
    @cPassword      VARCHAR(255)
)
AS
BEGIN
    SET NOCOUNT ON
    BEGIN TRY
        BEGIN TRAN
            UPDATE Usuario SET
                cPassword = @cPassword,
                bPrimerAcceso = 0
            WHERE nUsuarioId = @nUsuarioId
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