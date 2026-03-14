CREATE PROCEDURE PA_OrdenServicio_Lst_Historial(
    @nOrdenServicioId INT
)
AS
BEGIN
    SET NOCOUNT ON
    SELECT
        osh.nOrdenServicioHistorialId,
        eoa.cNombre AS cEstadoAnterior, eoa.cColor AS cEstadoAnteriorColor,
        eon.cNombre AS cEstadoNuevo, eon.cColor AS cEstadoNuevoColor,
        osh.cComentario, osh.dFechaCambio,
        pe.cNombres + ' ' + pe.cApellidoPaterno AS cUsuarioNombre
    FROM OrdenServicioHistorial osh
    LEFT JOIN EstadoOrden eoa ON osh.nEstadoOrdenAnteriorId = eoa.nEstadoOrdenId
    INNER JOIN EstadoOrden eon ON osh.nEstadoOrdenNuevoId = eon.nEstadoOrdenId
    LEFT JOIN Usuario u ON osh.nUsuarioId = u.nUsuarioId
    LEFT JOIN Personal per ON u.nPersonalId = per.nPersonalId
    LEFT JOIN Persona pe ON per.nPersonaId = pe.nPersonaId
    WHERE osh.nOrdenServicioId = @nOrdenServicioId
    ORDER BY osh.dFechaCambio DESC
END