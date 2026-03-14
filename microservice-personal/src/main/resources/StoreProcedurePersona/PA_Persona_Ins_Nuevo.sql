/*---------------------------------------------------------------------------------
PROPÓSITO           | Inserta una nueva persona
AUTOR               | Sibhell Dhaleska
FECHA DE CREACIÓN   | 2025-01-21
-----------------------------------------------------------------------------------
EJEMPLO:
    EXEC PA_Persona_Ins_Nuevo 1, '12345678', 'Juan', 'Pérez', 'García', 'M', '1990-01-15', '999888777', 'juan@email.com', 'Av. Principal 123'
-----------------------------------------------------------------------------------*/
CREATE PROCEDURE PA_Persona_Ins_Nuevo(
    @nTipoDocumentoId   INT,
    @cNumeroDocumento   VARCHAR(20),
    @cNombres           VARCHAR(100),
    @cApellidoPaterno   VARCHAR(100),
    @cApellidoMaterno   VARCHAR(100),
    @cSexo              CHAR(1),
    @dFechaNacimiento   DATE,
    @cTelefono          VARCHAR(20),
    @cEmail             VARCHAR(100),
    @cDireccion         VARCHAR(250)
)
AS
BEGIN
    SET NOCOUNT ON
    BEGIN TRY
        BEGIN TRAN
            IF EXISTS (SELECT 1 FROM Persona WHERE nTipoDocumentoId = @nTipoDocumentoId AND cNumeroDocumento = @cNumeroDocumento)
            BEGIN
                RAISERROR('Ya existe una persona con este documento', 16, 1)
                RETURN
            END

            INSERT INTO Persona (nTipoDocumentoId, cNumeroDocumento, cNombres, cApellidoPaterno, cApellidoMaterno, cSexo, dFechaNacimiento, cTelefono, cEmail, cDireccion)
            VALUES (@nTipoDocumentoId, @cNumeroDocumento, @cNombres, @cApellidoPaterno, @cApellidoMaterno, @cSexo, @dFechaNacimiento, @cTelefono, @cEmail, @cDireccion)

            SELECT SCOPE_IDENTITY() AS nPersonaId
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