CREATE PROCEDURE PA_TipoServicio_Lst_Todos
AS
BEGIN
    SET NOCOUNT ON
    SELECT nTipoServicioId, cTipoServicioCod, cNombre, cDescripcion, nPrecioBase, dFechaCreacion, bEstado
    FROM TipoServicio
    WHERE bEstado = 1
    ORDER BY cNombre
END