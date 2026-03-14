/*---------------------------------------------------------------------------------
PROPÓSITO          | Órdenes por estado (para gráfico de pastel)
---------------------------------------------------------------------------------*/
IF OBJECT_ID('PA_Reporte_Dashboard_PorEstado') IS NOT NULL
    DROP PROCEDURE PA_Reporte_Dashboard_PorEstado
GO

CREATE PROCEDURE PA_Reporte_Dashboard_PorEstado
AS
BEGIN
    SET NOCOUNT ON
    SELECT
        eo.cEstadoOrdenCod,
        eo.cNombre AS cEstadoNombre,
        eo.cColor,
        COUNT(os.nOrdenServicioId) AS nCantidad
    FROM EstadoOrden eo
    LEFT JOIN OrdenServicio os ON eo.nEstadoOrdenId = os.nEstadoOrdenId AND os.bEstado = 1
    GROUP BY eo.cEstadoOrdenCod, eo.cNombre, eo.cColor, eo.nOrden
    ORDER BY eo.nOrden
END