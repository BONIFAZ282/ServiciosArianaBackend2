IF OBJECT_ID('PA_ActividadEvidencia_Get_PorId') IS NOT NULL
    DROP PROCEDURE PA_ActividadEvidencia_Get_PorId
GO

CREATE PROCEDURE PA_ActividadEvidencia_Get_PorId(
    @nActividadEvidenciaId INT
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
    WHERE nActividadEvidenciaId = @nActividadEvidenciaId AND bEstado = 1
END