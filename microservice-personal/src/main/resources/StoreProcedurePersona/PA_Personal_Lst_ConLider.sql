/*---------------------------------------------------------------------------------
PROPÓSITO          | Lista empleados con su líder asignado
AUTOR              | Sibhell Dhaleska
FECHA CREACIÓN     | 2025-01-23
---------------------------------------------------------------------------------*/
IF OBJECT_ID('PA_Personal_Lst_ConLider') IS NOT NULL
    DROP PROCEDURE PA_Personal_Lst_ConLider
GO

CREATE PROCEDURE PA_Personal_Lst_ConLider
AS
BEGIN
    SET NOCOUNT ON
    SELECT
        pe.nPersonalId,
        p.cNombres + ' ' + p.cApellidoPaterno AS cNombreCompleto,
        c.nCargoId,
        c.cNombre AS cCargoNombre,
        p.cTelefono,
        pe.nPersonalLiderId,
        pl.cNombres + ' ' + pl.cApellidoPaterno AS cLiderNombre
    FROM Personal pe
    INNER JOIN Persona p ON pe.nPersonaId = p.nPersonaId
    INNER JOIN Cargo c ON pe.nCargoId = c.nCargoId
    LEFT JOIN Personal pel ON pe.nPersonalLiderId = pel.nPersonalId
    LEFT JOIN Persona pl ON pel.nPersonaId = pl.nPersonaId
    WHERE pe.bEstado = 1
    ORDER BY cLiderNombre, p.cApellidoPaterno, p.cNombres
END
GO