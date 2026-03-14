IF OBJECT_ID('PA_OrdenServicioDetalle_Get_TotalOrden') IS NOT NULL
    DROP PROCEDURE PA_OrdenServicioDetalle_Get_TotalOrden
GO

CREATE PROCEDURE PA_OrdenServicioDetalle_Get_TotalOrden(
    @nOrdenServicioId INT
)
AS
BEGIN
    SET NOCOUNT ON
    SELECT
        @nOrdenServicioId AS nOrdenServicioId,
        COUNT(*) AS nCantidadServicios,
        ISNULL(SUM(nSubtotal), 0) AS nTotalServicios
    FROM OrdenServicioDetalle
    WHERE nOrdenServicioId = @nOrdenServicioId AND bEstado = 1
END