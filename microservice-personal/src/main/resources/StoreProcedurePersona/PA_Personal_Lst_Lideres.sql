/*---------------------------------------------------------------------------------
PROPÓSITO           | Lista líderes disponibles para asignación
AUTOR               | Sibhell Dhaleska
FECHA DE CREACIÓN   | 2025-01-21
-----------------------------------------------------------------------------------
EJEMPLO:
    EXEC PA_Personal_Lst_Lideres
-----------------------------------------------------------------------------------*/
CREATE PROCEDURE PA_Personal_Lst_Lideres
AS
BEGIN
    SET NOCOUNT ON
    SELECT
        pe.nPersonalId,
        p.cNombres + ' ' + p.cApellidoPaterno + ' ' + ISNULL(p.cApellidoMaterno, '') AS cNombreCompleto,
        c.cNombre AS cCargoNombre
    FROM Personal pe
    INNER JOIN Persona p ON pe.nPersonaId = p.nPersonaId
    INNER JOIN Cargo c ON pe.nCargoId = c.nCargoId
    WHERE c.cCargoCod IN ('AD001', 'US001') AND pe.bEstado = 1
    ORDER BY p.cApellidoPaterno, p.cNombres
END