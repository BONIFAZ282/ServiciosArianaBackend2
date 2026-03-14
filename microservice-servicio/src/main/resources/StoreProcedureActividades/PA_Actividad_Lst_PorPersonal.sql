IF OBJECT_ID('PA_Actividad_Lst_PorPersonal') IS NOT NULL
    DROP PROCEDURE PA_Actividad_Lst_PorPersonal
GO

CREATE PROCEDURE PA_Actividad_Lst_PorPersonal(
    @nPersonalId INT
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
        a.cTitulo,
        a.cDescripcion,
        a.dFechaActividad,
        a.dFechaCreacion,
        (SELECT COUNT(*) FROM ActividadEvidencia WHERE nActividadId = a.nActividadId AND bEstado = 1) AS nTotalEvidencias
    FROM Actividad a
    INNER JOIN OrdenServicio os ON a.nOrdenServicioId = os.nOrdenServicioId
    WHERE a.nPersonalId = @nPersonalId AND a.bEstado = 1
    ORDER BY a.dFechaActividad DESC, a.dFechaCreacion DESC
END