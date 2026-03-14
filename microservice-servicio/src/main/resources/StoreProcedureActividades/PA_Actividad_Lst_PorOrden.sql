IF OBJECT_ID('PA_Actividad_Lst_PorOrden') IS NOT NULL
    DROP PROCEDURE PA_Actividad_Lst_PorOrden
GO

CREATE PROCEDURE PA_Actividad_Lst_PorOrden(
    @nOrdenServicioId INT
)
AS
BEGIN
    SET NOCOUNT ON
    SELECT
        a.nActividadId,
        a.nOrdenServicioId,
        a.nPersonalId,
        p.cNombres + ' ' + p.cApellidoPaterno AS cPersonalNombre,
        c.cNombre AS cCargoNombre,
        a.cTitulo,
        a.cDescripcion,
        a.dFechaActividad,
        a.dFechaCreacion,
        (SELECT COUNT(*) FROM ActividadEvidencia WHERE nActividadId = a.nActividadId AND bEstado = 1) AS nTotalEvidencias
    FROM Actividad a
    INNER JOIN Personal pe ON a.nPersonalId = pe.nPersonalId
    INNER JOIN Persona p ON pe.nPersonaId = p.nPersonaId
    INNER JOIN Cargo c ON pe.nCargoId = c.nCargoId
    WHERE a.nOrdenServicioId = @nOrdenServicioId AND a.bEstado = 1
    ORDER BY a.dFechaActividad DESC, a.dFechaCreacion DESC
END