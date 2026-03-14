
CREATE PROCEDURE PA_Cliente_Upd_Actualizar(
    @nClienteId         INT,
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
    @cRazonSocial       VARCHAR(200),
    @cNombreComercial   VARCHAR(200),
    @cObservaciones     VARCHAR(500),
    @bEstado            BIT
)
AS
BEGIN
    SET NOCOUNT ON
    BEGIN TRY
        BEGIN TRAN
            DECLARE @nPersonaId INT
            SELECT @nPersonaId = nPersonaId FROM Cliente WHERE nClienteId = @nClienteId

            IF @nPersonaId IS NULL
            BEGIN
                RAISERROR('El cliente no existe', 16, 1)
                RETURN
            END

            -- Validar documento duplicado
            IF EXISTS (
                SELECT 1 FROM Persona
                WHERE nTipoDocumentoId = @nTipoDocumentoId AND cNumeroDocumento = @cNumeroDocumento AND nPersonaId != @nPersonaId
            )
            BEGIN
                RAISERROR('Ya existe otra persona con este número de documento', 16, 1)
                RETURN
            END

            -- Actualizar Persona
            UPDATE Persona SET
                nTipoDocumentoId = @nTipoDocumentoId, cNumeroDocumento = @cNumeroDocumento,
                cNombres = @cNombres, cApellidoPaterno = @cApellidoPaterno, cApellidoMaterno = @cApellidoMaterno,
                cSexo = @cSexo, dFechaNacimiento = @dFechaNacimiento,
                cTelefono = @cTelefono, cEmail = @cEmail, cDireccion = @cDireccion
            WHERE nPersonaId = @nPersonaId

            -- Actualizar Cliente
            UPDATE Cliente SET
                cRazonSocial = @cRazonSocial, cNombreComercial = @cNombreComercial,
                cObservaciones = @cObservaciones, bEstado = @bEstado
            WHERE nClienteId = @nClienteId

            SELECT @nClienteId AS nClienteId
        COMMIT TRAN
    END TRY
    BEGIN CATCH
        IF @@TRANCOUNT > 0 ROLLBACK TRAN
        DECLARE @ErrorMessage NVARCHAR(4000) = ERROR_MESSAGE()
        RAISERROR(@ErrorMessage, 16, 1)
    END CATCH
END