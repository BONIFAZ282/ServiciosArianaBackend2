IF OBJECT_ID('PA_Actividad_Get_PorId') IS NOT NULL
    DROP PROCEDURE PA_Actividad_Get_PorId
GO

CREATE PROCEDURE PA_Actividad_Get_PorId(
    @nActividadId INT
)
AS
BEGIN
    SET NOCOUNT ON
    SELECT
        a.nActividadId,
        a.nOrdenServicioId,
        os.cOrdenServicioCod,
        os.cTitulo AS cOrdenTitulo,
        a.nPersonalId,
        p.cNombres + ' ' + p.cApellidoPaterno AS cPersonalNombre,
        a.cTitulo,
        a.cDescripcion,
        a.dFechaActividad,
        a.dFechaCreacion,
        (SELECT COUNT(*) FROM ActividadEvidencia WHERE nActividadId = a.nActividadId AND bEstado = 1) AS nTotalEvidencias,
        a.bEstado
    FROM Actividad a
    INNER JOIN OrdenServicio os ON a.nOrdenServicioId = os.nOrdenServicioId
    INNER JOIN Personal pe ON a.nPersonalId = pe.nPersonalId
    INNER JOIN Persona p ON pe.nPersonaId = p.nPersonaId
    WHERE a.nActividadId = @nActividadId AND a.bEstado = 1
END