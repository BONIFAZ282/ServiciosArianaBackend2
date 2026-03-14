CREATE PROCEDURE PA_Personal_Lst_Todos
AS
BEGIN
    SET NOCOUNT ON
    SELECT
        pe.nPersonalId,
        pe.nPersonaId,
        p.nTipoDocumentoId,
        td.cNombre AS cTipoDocNombre,
        p.cNumeroDocumento,
        p.cNombres,
        p.cApellidoPaterno,
        p.cApellidoMaterno,
        p.cNombres + ' ' + p.cApellidoPaterno + ' ' + ISNULL(p.cApellidoMaterno, '') AS cNombreCompleto,
        p.dFechaNacimiento,
        p.cTelefono,
        p.cEmail,
        p.cDireccion,
        pe.nCargoId,
        c.cCargoCod,
        c.cNombre AS cCargoNombre,
        pe.nPersonalLiderId,
        pl.cNombres + ' ' + pl.cApellidoPaterno AS cLiderNombre,
        pe.dFechaIngreso,
        pe.nSueldo,
        pe.bEstado,
        -- Campos de Usuario (nuevos)
        u.nUsuarioId,
        u.cUsuario,
        CASE WHEN u.nUsuarioId IS NOT NULL THEN 1 ELSE 0 END AS bTieneUsuario
    FROM Personal pe
    INNER JOIN Persona p ON pe.nPersonaId = p.nPersonaId
    INNER JOIN TipoDocumento td ON p.nTipoDocumentoId = td.nTipoDocumentoId
    INNER JOIN Cargo c ON pe.nCargoId = c.nCargoId
    LEFT JOIN Personal pel ON pe.nPersonalLiderId = pel.nPersonalId
    LEFT JOIN Persona pl ON pel.nPersonaId = pl.nPersonaId
    LEFT JOIN Usuario u ON pe.nPersonalId = u.nPersonalId  -- ← NUEVO
    WHERE pe.bEstado = 1
    ORDER BY p.cApellidoPaterno, p.cNombres
END