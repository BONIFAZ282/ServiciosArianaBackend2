/*---------------------------------------------------------------------------------
PROPÓSITO           | Lista personal por cargo
AUTOR               | Sibhell Dhaleska
FECHA DE CREACIÓN   | 2025-01-21
-----------------------------------------------------------------------------------
EJEMPLO:
    EXEC PA_Personal_Lst_PorCargo 1
-----------------------------------------------------------------------------------*/
CREATE PROCEDURE PA_Personal_Lst_PorCargo(
    @nCargoId INT
)
AS
BEGIN
    SET NOCOUNT ON
    SELECT
        pe.nPersonalId,
        p.cNumeroDocumento,
        p.cNombres + ' ' + p.cApellidoPaterno + ' ' + ISNULL(p.cApellidoMaterno, '') AS cNombreCompleto,
        p.cTelefono,
        p.cEmail,
        c.cNombre AS cCargoNombre,
        pe.dFechaIngreso,
        pe.bEstado
    FROM Personal pe
    INNER JOIN Persona p ON pe.nPersonaId = p.nPersonaId
    INNER JOIN Cargo c ON pe.nCargoId = c.nCargoId
    WHERE pe.nCargoId = @nCargoId AND pe.bEstado = 1
    ORDER BY p.cApellidoPaterno, p.cNombres
END