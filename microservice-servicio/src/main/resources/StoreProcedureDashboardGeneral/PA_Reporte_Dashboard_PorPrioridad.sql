
/*---------------------------------------------------------------------------------
PROPÓSITO          | Órdenes por prioridad (para gráfico de barras)
---------------------------------------------------------------------------------*/
IF OBJECT_ID('PA_Reporte_Dashboard_PorPrioridad') IS NOT NULL
    DROP PROCEDURE PA_Reporte_Dashboard_PorPrioridad
GO

CREATE PROCEDURE PA_Reporte_Dashboard_PorPrioridad
AS
BEGIN
    SET NOCOUNT ON
    SELECT
        p.cPrioridadCod,
        p.cNombre AS cPrioridadNombre,
        p.cColor,
        COUNT(os.nOrdenServicioId) AS nCantidad
    FROM Prioridad p
    LEFT JOIN OrdenServicio os ON p.nPrioridadId = os.nPrioridadId AND os.bEstado = 1
    GROUP BY p.cPrioridadCod, p.cNombre, p.cColor, p.nOrden
    ORDER BY p.nOrden
END