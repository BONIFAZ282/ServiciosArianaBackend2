
/*---------------------------------------------------------------------------------
PROPÓSITO           | Crea un nuevo usuario
AUTOR               | Sibhell Dhaleska
FECHA DE CREACIÓN   | 2025-01-21
-----------------------------------------------------------------------------------
EJEMPLO:
    EXEC PA_Usuario_Ins_Nuevo 1, 'jperez', '$2a$10$...'
-----------------------------------------------------------------------------------*/
CREATE PROCEDURE PA_Usuario_Ins_Nuevo(
    @nPersonalId    INT,
    @cUsuario       VARCHAR(50),
    @cPassword      VARCHAR(255)
)
AS
BEGIN
    SET NOCOUNT ON
    BEGIN TRY
        BEGIN TRAN
            IF EXISTS (SELECT 1 FROM Usuario WHERE cUsuario = @cUsuario)
            BEGIN
                RAISERROR('El nombre de usuario ya existe', 16, 1)
                RETURN
            END

            IF EXISTS (SELECT 1 FROM Usuario WHERE nPersonalId = @nPersonalId)
            BEGIN
                RAISERROR('El personal ya tiene un usuario asignado', 16, 1)
                RETURN
            END

            INSERT INTO Usuario (nPersonalId, cUsuario, cPassword)
            VALUES (@nPersonalId, @cUsuario, @cPassword)

            SELECT SCOPE_IDENTITY() AS nUsuarioId
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
