
CREATE PROCEDURE PA_Cliente_Get_ExisteDocumento(
    @nTipoDocumentoId   INT,
    @cNumeroDocumento   VARCHAR(20)
)
AS
BEGIN
    SET NOCOUNT ON

    IF EXISTS (
        SELECT 1 FROM Cliente c
        INNER JOIN Persona p ON c.nPersonaId = p.nPersonaId
        WHERE p.nTipoDocumentoId = @nTipoDocumentoId AND p.cNumeroDocumento = @cNumeroDocumento
    )
    BEGIN
        SELECT 1 AS bExiste, 'El cliente ya está registrado con este número de documento' AS cMensaje
        RETURN
    END

    SELECT 0 AS bExiste, 'Documento disponible' AS cMensaje
END