/*---------------------------------------------------------------------------------
PROPÓSITO          | Top 10 tipos de servicio más solicitados
---------------------------------------------------------------------------------*/
IF OBJECT_ID('PA_Reporte_Dashboard_TopServicios') IS NOT NULL
    DROP PROCEDURE PA_Reporte_Dashboard_TopServicios
GO

CREATE PROCEDURE PA_Reporte_Dashboard_TopServicios
AS
BEGIN
    SET NOCOUNT ON
    SELECT TOP 10
        ts.nTipoServicioId,
        ts.cNombre AS cTipoServicioNombre,
        COUNT(osd.nOrdenServicioDetalleId) AS nVecesSolicitado,
        ISNULL(SUM(osd.nSubtotal), 0) AS nTotalGenerado
    FROM TipoServicio ts
    LEFT JOIN OrdenServicioDetalle osd ON ts.nTipoServicioId = osd.nTipoServicioId AND osd.bEstado = 1
    WHERE ts.bEstado = 1
    GROUP BY ts.nTipoServicioId, ts.cNombre
    ORDER BY nVecesSolicitado DESC
END