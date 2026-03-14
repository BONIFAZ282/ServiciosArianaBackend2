/*---------------------------------------------------------------------------------
PROPÓSITO           | Actualiza una persona existente
AUTOR               | Sibhell Dhaleska
FECHA DE CREACIÓN   | 2025-01-21
-----------------------------------------------------------------------------------
EJEMPLO:
    EXEC PA_Persona_Upd_Actualizar 1, 1, '12345678', 'Juan', 'Pérez', 'García', 'M', '1990-01-15', '999888777', 'juan@email.com', 'Av. Principal 123', 1
-----------------------------------------------------------------------------------*/
CREATE PROCEDURE PA_Persona_Upd_Actualizar(
    @nPersonaId         INT,
    @nTipoDocumentoId   INT,
    @cNumeroDocumento   VARCHAR(20),
    @cNombres           VARCHAR(100),
    @cApellidoPaterno   VARCHAR(100),
    @cApellidoMaterno   VARCHAR(100),
    @cSexo              CHAR(1),
    @dFechaNacimiento   DATE,
    @cTelefono          VARCHAR(20),
    @cEmail             VARCHAR(100),
    @cDireccion         VARCHAR(250),
    @bEstado            BIT
)
AS
BEGIN
    SET NOCOUNT ON
    BEGIN TRY
        BEGIN TRAN
            UPDATE Persona SET
                nTipoDocumentoId = @nTipoDocumentoId,
                cNumeroDocumento = @cNumeroDocumento,
                cNombres = @cNombres,
                cApellidoPaterno = @cApellidoPaterno,
                cApellidoMaterno = @cApellidoMaterno,
                cSexo = @cSexo,
                dFechaNacimiento = @dFechaNacimiento,
                cTelefono = @cTelefono,
                cEmail = @cEmail,
                cDireccion = @cDireccion,
                bEstado = @bEstado
            WHERE nPersonaId = @nPersonaId

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