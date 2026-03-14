/*---------------------------------------------------------------------------------
PROPÓSITO           | Obtiene un personal por ID con todos sus datos
AUTOR               | Sibhell Dhaleska
FECHA DE CREACIÓN   | 2025-01-21
-----------------------------------------------------------------------------------
EJEMPLO:
    EXEC PA_Personal_Get_PorId 1
-----------------------------------------------------------------------------------*/
CREATE PROCEDURE PA_Personal_Get_PorId(
    @nPersonalId INT
)
AS
BEGIN
    SET NOCOUNT ON
    SELECT
        pe.nPersonalId,
        pe.nPersonaId,
        p.cNumeroDocumento,
        p.cNombres,
        p.cApellidoPaterno,
        p.cApellidoMaterno,
        p.cNombres + ' ' + p.cApellidoPaterno + ' ' + ISNULL(p.cApellidoMaterno, '') AS cNombreCompleto,
        p.cSexo,
        p.dFechaNacimiento,
        p.cTelefono,
        p.cEmail,
        p.cDireccion,
        td.nTipoDocumentoId,
        td.cTipoDocCod,
        pe.nCargoId,
        c.cCargoCod,
        c.cNombre AS cCargoNombre,
        pe.nPersonalLiderId,
        pl.cNombres + ' ' + pl.cApellidoPaterno AS cLiderNombre,
        pe.dFechaIngreso,
        pe.dFechaCese,
        pe.nSueldo,
        pe.cObservaciones,
        pe.dFechaCreacion,
        pe.bEstado
    FROM Personal pe
    INNER JOIN Persona p ON pe.nPersonaId = p.nPersonaId
    INNER JOIN TipoDocumento td ON p.nTipoDocumentoId = td.nTipoDocumentoId
    INNER JOIN Cargo c ON pe.nCargoId = c.nCargoId
    LEFT JOIN Personal pel ON pe.nPersonalLiderId = pel.nPersonalId
    LEFT JOIN Persona pl ON pel.nPersonaId = pl.nPersonaId
    WHERE pe.nPersonalId = @nPersonalId
END