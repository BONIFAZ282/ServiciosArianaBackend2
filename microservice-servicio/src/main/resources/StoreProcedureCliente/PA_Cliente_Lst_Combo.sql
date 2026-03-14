CREATE PROCEDURE PA_Cliente_Lst_Combo
AS
BEGIN
    SET NOCOUNT ON
    SELECT
        c.nClienteId,
        c.cClienteCod,
        COALESCE(c.cRazonSocial, p.cNombres + ' ' + p.cApellidoPaterno) AS cNombreMostrar,
        p.cNumeroDocumento
    FROM Cliente c
    INNER JOIN Persona p ON c.nPersonaId = p.nPersonaId
    WHERE c.bEstado = 1
    ORDER BY cNombreMostrar
END