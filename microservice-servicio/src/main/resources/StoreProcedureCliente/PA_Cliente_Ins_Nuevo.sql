
CREATE PROCEDURE PA_Cliente_Ins_Nuevo(
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
    @cObservaciones     VARCHAR(500)
)
AS
BEGIN
    SET NOCOUNT ON
    BEGIN TRY
        BEGIN TRAN
            -- Validar si ya existe como cliente
            IF EXISTS (
                SELECT 1 FROM Cliente c
                INNER JOIN Persona p ON c.nPersonaId = p.nPersonaId
                WHERE p.nTipoDocumentoId = @nTipoDocumentoId AND p.cNumeroDocumento = @cNumeroDocumento
            )
            BEGIN
                RAISERROR('El cliente ya está registrado con este número de documento', 16, 1)
                RETURN
            END

            -- Insertar Persona
            DECLARE @nPersonaId INT

            INSERT INTO Persona (nTipoDocumentoId, cNumeroDocumento, cNombres, cApellidoPaterno, cApellidoMaterno, cSexo, dFechaNacimiento, cTelefono, cEmail, cDireccion)
            VALUES (@nTipoDocumentoId, @cNumeroDocumento, @cNombres, @cApellidoPaterno, @cApellidoMaterno, @cSexo, @dFechaNacimiento, @cTelefono, @cEmail, @cDireccion)

            SET @nPersonaId = SCOPE_IDENTITY()

            -- Generar código de cliente
            DECLARE @cClienteCod VARCHAR(20)
            DECLARE @nCorrelativo INT

            SELECT @nCorrelativo = ISNULL(MAX(CAST(SUBSTRING(cClienteCod, 4, 10) AS INT)), 0) + 1 FROM Cliente
            SET @cClienteCod = 'CLI' + RIGHT('000' + CAST(@nCorrelativo AS VARCHAR), 3)

            -- Insertar Cliente
            INSERT INTO Cliente (nPersonaId, cClienteCod, cRazonSocial, cNombreComercial, cObservaciones)
            VALUES (@nPersonaId, @cClienteCod, @cRazonSocial, @cNombreComercial, @cObservaciones)

            SELECT SCOPE_IDENTITY() AS nClienteId, @cClienteCod AS cClienteCod
        COMMIT TRAN
    END TRY
    BEGIN CATCH
        IF @@TRANCOUNT > 0 ROLLBACK TRAN
        DECLARE @ErrorMessage NVARCHAR(4000) = ERROR_MESSAGE()
        RAISERROR(@ErrorMessage, 16, 1)
    END CATCH
END
