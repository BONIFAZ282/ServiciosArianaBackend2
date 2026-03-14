IF OBJECT_ID('PA_ActividadEvidencia_Lst_PorActividad') IS NOT NULL
    DROP PROCEDURE PA_ActividadEvidencia_Lst_PorActividad
GO

CREATE PROCEDURE PA_ActividadEvidencia_Lst_PorActividad(
    @nActividadId INT
)
AS
BEGIN
    SET NOCOUNT ON
    SELECT
        nActividadEvidenciaId,
        nActividadId,
        cNombreArchivo,
        cRutaArchivo,
        cTipoArchivo,
        nTamano,
        dFechaCreacion,
        bEstado
    FROM ActividadEvidencia
    WHERE nActividadId = @nActividadId AND bEstado = 1
    ORDER BY dFechaCreacion DESC
END