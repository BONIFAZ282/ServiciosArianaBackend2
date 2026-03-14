
/*---------------------------------------------------------------------------------
PROPÓSITO          | Lista servicios de una orden
---------------------------------------------------------------------------------*/
IF OBJECT_ID('PA_OrdenServicioDetalle_Lst_PorOrden') IS NOT NULL
    DROP PROCEDURE PA_OrdenServicioDetalle_Lst_PorOrden
GO

CREATE PROCEDURE PA_OrdenServicioDetalle_Lst_PorOrden(
    @nOrdenServicioId INT
)
AS
BEGIN
    SET NOCOUNT ON
    SELECT
        osd.nOrdenServicioDetalleId,
        osd.nOrdenServicioId,
        osd.nTipoServicioId,
        ts.cTipoServicioCod,
        ts.cNombre AS cTipoServicioNombre,
        osd.cDescripcion,
        osd.nCantidad,
        osd.nPrecioUnitario,
        osd.nSubtotal,
        osd.bEstado
    FROM OrdenServicioDetalle osd
    INNER JOIN TipoServicio ts ON osd.nTipoServicioId = ts.nTipoServicioId
    WHERE osd.nOrdenServicioId = @nOrdenServicioId AND osd.bEstado = 1
    ORDER BY osd.nOrdenServicioDetalleId
END