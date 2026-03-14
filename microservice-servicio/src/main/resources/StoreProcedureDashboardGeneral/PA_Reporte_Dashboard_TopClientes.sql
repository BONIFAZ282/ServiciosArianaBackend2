/*---------------------------------------------------------------------------------
PROPÓSITO          | Top 10 clientes con más órdenes
---------------------------------------------------------------------------------*/
IF OBJECT_ID('PA_Reporte_Dashboard_TopClientes') IS NOT NULL
    DROP PROCEDURE PA_Reporte_Dashboard_TopClientes
GO

CREATE PROCEDURE PA_Reporte_Dashboard_TopClientes
AS
BEGIN
    SET NOCOUNT ON
    SELECT TOP 10
        c.nClienteId,
        COALESCE(c.cRazonSocial, p.cNombres + ' ' + p.cApellidoPaterno) AS cClienteNombre,
        COUNT(os.nOrdenServicioId) AS nTotalOrdenes,
        ISNULL(SUM(os.nCostoReal), 0) AS nTotalFacturado
    FROM Cliente c
    INNER JOIN Persona p ON c.nPersonaId = p.nPersonaId
    INNER JOIN OrdenServicio os ON c.nClienteId = os.nClienteId AND os.bEstado = 1
    WHERE c.bEstado = 1
    GROUP BY c.nClienteId, c.cRazonSocial, p.cNombres, p.cApellidoPaterno
    ORDER BY nTotalOrdenes DESC
END