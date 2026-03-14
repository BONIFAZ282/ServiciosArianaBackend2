/*---------------------------------------------------------------------------------
PROPÓSITO           | Lista todos los usuarios
AUTOR               | Sibhell Dhaleska
FECHA DE CREACIÓN   | 2025-01-21
-----------------------------------------------------------------------------------
EJEMPLO:
    EXEC PA_Usuario_Lst_Todos
-----------------------------------------------------------------------------------*/
CREATE PROCEDURE PA_Usuario_Lst_Todos
AS
BEGIN
    SET NOCOUNT ON
    SELECT
        u.nUsuarioId,
        u.nPersonalId,
        u.cUsuario,
        u.nIntentosFallidos,
        u.dFechaBloqueo,
        u.dFechaCreacion,
        u.dUltimoAcceso,
        u.bPrimerAcceso,
        u.bEstado,
        p.cNombres + ' ' + p.cApellidoPaterno AS cNombreCompleto,
        c.cNombre AS cCargoNombre
    FROM Usuario u
    INNER JOIN Personal pe ON u.nPersonalId = pe.nPersonalId
    INNER JOIN Persona p ON pe.nPersonaId = p.nPersonaId
    INNER JOIN Cargo c ON pe.nCargoId = c.nCargoId
    ORDER BY u.cUsuario
END