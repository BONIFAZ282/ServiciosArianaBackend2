
CREATE PROCEDURE PA_OrdenServicio_Get_PorId(
    @nOrdenServicioId INT
)
AS
BEGIN
    SET NOCOUNT ON
    SELECT
        os.nOrdenServicioId, os.cOrdenServicioCod,
        os.nClienteId, c.cClienteCod,
        COALESCE(c.cRazonSocial, p.cNombres + ' ' + p.cApellidoPaterno) AS cClienteNombre,
        p.cNumeroDocumento AS cClienteDocumento, p.cTelefono AS cClienteTelefono, p.cEmail AS cClienteEmail,
        os.nTipoServicioId, ts.cTipoServicioCod, ts.cNombre AS cTipoServicioNombre,
        os.nPrioridadId, pr.cPrioridadCod, pr.cNombre AS cPrioridadNombre, pr.cColor AS cPrioridadColor,
        os.nEstadoOrdenId, eo.cEstadoOrdenCod, eo.cNombre AS cEstadoOrdenNombre, eo.cColor AS cEstadoOrdenColor, eo.bPermiteEditar,
        os.cTitulo, os.cDescripcion, os.dFechaInicio, os.dFechaFin, os.dFechaFinReal,
        os.nPersonalLiderId, pl.cNombres + ' ' + pl.cApellidoPaterno AS cPersonalLiderNombre,
        os.cDireccionServicio, os.nCostoEstimado, os.nCostoReal, os.cObservaciones,
        os.dFechaCreacion, os.nUsuarioCreacionId, os.bEstado
    FROM OrdenServicio os
    INNER JOIN Cliente c ON os.nClienteId = c.nClienteId
    INNER JOIN Persona p ON c.nPersonaId = p.nPersonaId
    INNER JOIN TipoServicio ts ON os.nTipoServicioId = ts.nTipoServicioId
    INNER JOIN Prioridad pr ON os.nPrioridadId = pr.nPrioridadId
    INNER JOIN EstadoOrden eo ON os.nEstadoOrdenId = eo.nEstadoOrdenId
    LEFT JOIN Personal pe ON os.nPersonalLiderId = pe.nPersonalId
    LEFT JOIN Persona pl ON pe.nPersonaId = pl.nPersonaId
    WHERE os.nOrdenServicioId = @nOrdenServicioId
END