CREATE PROCEDURE PA_EstadoOrden_Lst_Todos
AS
BEGIN
    SET NOCOUNT ON
    SELECT nEstadoOrdenId, cEstadoOrdenCod, cNombre, cDescripcion, cColor, nOrden, bPermiteEditar
    FROM EstadoOrden
    WHERE bEstado = 1
    ORDER BY nOrden
END
GO

CREATE PROCEDURE PA_EstadoOrden_Lst_SiguientesValidos(
    @cEstadoOrdenCodActual VARCHAR(20)
)
AS
BEGIN
    SET NOCOUNT ON

    IF @cEstadoOrdenCodActual = 'PENDIENTE'
        SELECT nEstadoOrdenId, cEstadoOrdenCod, cNombre, cColor
        FROM EstadoOrden WHERE cEstadoOrdenCod IN ('EN_PROCESO', 'CANCELADO') AND bEstado = 1
    ELSE IF @cEstadoOrdenCodActual = 'EN_PROCESO'
        SELECT nEstadoOrdenId, cEstadoOrdenCod, cNombre, cColor
        FROM EstadoOrden WHERE cEstadoOrdenCod IN ('FINALIZADO', 'CANCELADO') AND bEstado = 1
    ELSE IF @cEstadoOrdenCodActual = 'FINALIZADO'
        SELECT nEstadoOrdenId, cEstadoOrdenCod, cNombre, cColor
        FROM EstadoOrden WHERE cEstadoOrdenCod IN ('RESUELTO', 'OBSERVADO') AND bEstado = 1
    ELSE IF @cEstadoOrdenCodActual = 'OBSERVADO'
        SELECT nEstadoOrdenId, cEstadoOrdenCod, cNombre, cColor
        FROM EstadoOrden WHERE cEstadoOrdenCod = 'EN_PROCESO' AND bEstado = 1
    ELSE
        SELECT nEstadoOrdenId, cEstadoOrdenCod, cNombre, cColor
        FROM EstadoOrden WHERE 1 = 0
END