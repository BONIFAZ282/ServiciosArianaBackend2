/*---------------------------------------------------------------------------------
PROPÓSITO          | Órdenes por mes (últimos 12 meses - para gráfico de líneas)
---------------------------------------------------------------------------------*/
IF OBJECT_ID('PA_Reporte_Dashboard_PorMes') IS NOT NULL
    DROP PROCEDURE PA_Reporte_Dashboard_PorMes
GO

CREATE PROCEDURE PA_Reporte_Dashboard_PorMes
AS
BEGIN
    SET NOCOUNT ON
    ;WITH Meses AS (
        SELECT 0 AS n UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3
        UNION ALL SELECT 4 UNION ALL SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7
        UNION ALL SELECT 8 UNION ALL SELECT 9 UNION ALL SELECT 10 UNION ALL SELECT 11
    )
    SELECT
        YEAR(DATEADD(MONTH, -n, GETDATE())) AS nAnio,
        MONTH(DATEADD(MONTH, -n, GETDATE())) AS nMes,
        FORMAT(DATEADD(MONTH, -n, GETDATE()), 'MMM yyyy') AS cMesAnio,
        (SELECT COUNT(*) FROM OrdenServicio
         WHERE YEAR(dFechaCreacion) = YEAR(DATEADD(MONTH, -n, GETDATE()))
         AND MONTH(dFechaCreacion) = MONTH(DATEADD(MONTH, -n, GETDATE()))
         AND bEstado = 1) AS nCantidad,
        (SELECT ISNULL(SUM(nCostoReal), 0) FROM OrdenServicio
         WHERE YEAR(dFechaCreacion) = YEAR(DATEADD(MONTH, -n, GETDATE()))
         AND MONTH(dFechaCreacion) = MONTH(DATEADD(MONTH, -n, GETDATE()))
         AND bEstado = 1) AS nIngresos
    FROM Meses
    ORDER BY nAnio, nMes
END