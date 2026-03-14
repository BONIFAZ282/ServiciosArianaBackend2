
/*---------------------------------------------------------------------------------
PROPÓSITO           | Obtiene usuario por ID
AUTOR               | Sibhell Dhaleska
FECHA DE CREACIÓN   | 2025-01-21
-----------------------------------------------------------------------------------
EJEMPLO:
    EXEC PA_Usuario_Get_PorId 1
-----------------------------------------------------------------------------------*/
CREATE PROCEDURE PA_Usuario_Get_PorId(
    @nUsuarioId INT
)
AS
BEGIN
    SET NOCOUNT ON
    SELECT
        u.nUsuarioId,
        u.nPersonalId,
        u.cUsuario,
        u.cPassword,
        u.nIntentosFallidos,
        u.dFechaBloqueo,
        u.dFechaCreacion,
        u.dUltimoAcceso,
        u.bPrimerAcceso,
        u.bEstado,
        pe.nCargoId,
        c.cCargoCod,
        c.cNombre AS cCargoNombre,
        p.cNombres,
        p.cApellidoPaterno,
        p.cNombres + ' ' + p.cApellidoPaterno + ' ' + ISNULL(p.cApellidoMaterno, '') AS cNombreCompleto
    FROM Usuario u WITH(NOLOCK)
    INNER JOIN Personal pe WITH(NOLOCK) ON u.nPersonalId = pe.nPersonalId
    INNER JOIN Persona p WITH(NOLOCK) ON pe.nPersonaId = p.nPersonaId
    INNER JOIN Cargo c WITH(NOLOCK) ON pe.nCargoId = c.nCargoId
    WHERE u.nUsuarioId = @nUsuarioId
END