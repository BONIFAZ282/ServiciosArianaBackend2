/*=================================================================================
  PROCEDIMIENTOS ALMACENADOS: Reportes Dashboard General
  AUTOR:         Sibhell Dhaleska
  FECHA:         2025-01-23
===================================================================================*/

/*---------------------------------------------------------------------------------
PROPÓSITO          | Resumen general de órdenes
---------------------------------------------------------------------------------*/
IF OBJECT_ID('PA_Reporte_Dashboard_Resumen') IS NOT NULL
    DROP PROCEDURE PA_Reporte_Dashboard_Resumen
GO

CREATE PROCEDURE PA_Reporte_Dashboard_Resumen
AS
BEGIN
    SET NOCOUNT ON
    SELECT
        (SELECT COUNT(*) FROM OrdenServicio WHERE bEstado = 1) AS nTotalOrdenes,
        (SELECT COUNT(*) FROM OrdenServicio os
         INNER JOIN EstadoOrden eo ON os.nEstadoOrdenId = eo.nEstadoOrdenId
         WHERE eo.cEstadoOrdenCod = 'PENDIENTE' AND os.bEstado = 1) AS nPendientes,
        (SELECT COUNT(*) FROM OrdenServicio os
         INNER JOIN EstadoOrden eo ON os.nEstadoOrdenId = eo.nEstadoOrdenId
         WHERE eo.cEstadoOrdenCod = 'EN_PROCESO' AND os.bEstado = 1) AS nEnProceso,
        (SELECT COUNT(*) FROM OrdenServicio os
         INNER JOIN EstadoOrden eo ON os.nEstadoOrdenId = eo.nEstadoOrdenId
         WHERE eo.cEstadoOrdenCod = 'FINALIZADO' AND os.bEstado = 1) AS nFinalizadas,
        (SELECT COUNT(*) FROM OrdenServicio os
         INNER JOIN EstadoOrden eo ON os.nEstadoOrdenId = eo.nEstadoOrdenId
         WHERE eo.cEstadoOrdenCod = 'RESUELTO' AND os.bEstado = 1) AS nResueltas,
        (SELECT COUNT(*) FROM OrdenServicio os
         INNER JOIN EstadoOrden eo ON os.nEstadoOrdenId = eo.nEstadoOrdenId
         WHERE eo.cEstadoOrdenCod = 'CANCELADO' AND os.bEstado = 1) AS nCanceladas,
        (SELECT COUNT(*) FROM OrdenServicio os
         INNER JOIN EstadoOrden eo ON os.nEstadoOrdenId = eo.nEstadoOrdenId
         WHERE eo.cEstadoOrdenCod = 'OBSERVADO' AND os.bEstado = 1) AS nObservadas,
        (SELECT ISNULL(SUM(nCostoEstimado), 0) FROM OrdenServicio WHERE bEstado = 1) AS nTotalEstimado,
        (SELECT ISNULL(SUM(nCostoReal), 0) FROM OrdenServicio WHERE bEstado = 1) AS nTotalReal,
        (SELECT COUNT(*) FROM Cliente WHERE bEstado = 1) AS nTotalClientes,
        (SELECT COUNT(*) FROM Personal WHERE bEstado = 1) AS nTotalPersonal
END