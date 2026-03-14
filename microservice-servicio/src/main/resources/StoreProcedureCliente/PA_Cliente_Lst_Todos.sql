
CREATE PROCEDURE PA_Cliente_Lst_Todos
AS
BEGIN
    SET NOCOUNT ON
    SELECT
        c.nClienteId, c.cClienteCod,
        p.nTipoDocumentoId, td.cTipoDocCod, p.cNumeroDocumento,
        p.cNombres, p.cApellidoPaterno, p.cApellidoMaterno,
        c.cRazonSocial, c.cNombreComercial,
        COALESCE(c.cRazonSocial, p.cNombres + ' ' + p.cApellidoPaterno) AS cNombreMostrar,
        p.cTelefono, p.cEmail, p.cDireccion,
        c.dFechaRegistro, c.bEstado
    FROM Cliente c
    INNER JOIN Persona p ON c.nPersonaId = p.nPersonaId
    INNER JOIN TipoDocumento td ON p.nTipoDocumentoId = td.nTipoDocumentoId
    WHERE c.bEstado = 1
    ORDER BY c.cClienteCod
END