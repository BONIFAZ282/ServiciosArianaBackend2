/*---------------------------------------------------------------------------------
PROPÓSITO          | Órdenes vencidas (pasaron fecha fin sin completarse)
---------------------------------------------------------------------------------*/
IF OBJECT_ID('PA_Reporte_Dashboard_OrdenesVencidas') IS NOT NULL
    DROP PROCEDURE PA_Reporte_Dashboard_OrdenesVencidas
GO

CREATE PROCEDURE PA_Reporte_Dashboard_OrdenesVencidas
AS
BEGIN
    SET NOCOUNT ON
    SELECT
        os.nOrdenServicioId,
        os.cOrdenServicioCod,
        os.cTitulo,
        COALESCE(c.cRazonSocial, p.cNombres + ' ' + p.cApellidoPaterno) AS cClienteNombre,
        eo.cNombre AS cEstadoNombre,
        eo.cColor AS cEstadoColor,
        pr.cNombre AS cPrioridadNombre,
        pr.cColor AS cPrioridadColor,
        os.dFechaFin,
        DATEDIFF(DAY, os.dFechaFin, GETDATE()) AS nDiasVencido,
        pl.cNombres + ' ' + pl.cApellidoPaterno AS cLiderNombre
    FROM OrdenServicio os
    INNER JOIN EstadoOrden eo ON os.nEstadoOrdenId = eo.nEstadoOrdenId
    INNER JOIN Prioridad pr ON os.nPrioridadId = pr.nPrioridadId
    INNER JOIN Cliente c ON os.nClienteId = c.nClienteId
    INNER JOIN Persona p ON c.nPersonaId = p.nPersonaId
    LEFT JOIN Personal pe ON os.nPersonalLiderId = pe.nPersonalId
    LEFT JOIN Persona pl ON pe.nPersonaId = pl.nPersonaId
    WHERE os.bEstado = 1
    AND os.dFechaFin < CAST(GETDATE() AS DATE)
    AND eo.cEstadoOrdenCod NOT IN ('RESUELTO', 'CANCELADO')
    ORDER BY nDiasVencido DESC
END