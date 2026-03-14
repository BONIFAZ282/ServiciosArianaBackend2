
CREATE PROCEDURE PA_OrdenServicio_Lst_Todos
AS
BEGIN
    SET NOCOUNT ON
    SELECT
        os.nOrdenServicioId, os.cOrdenServicioCod,
        os.nClienteId, COALESCE(c.cRazonSocial, p.cNombres + ' ' + p.cApellidoPaterno) AS cClienteNombre,
        os.nTipoServicioId, ts.cNombre AS cTipoServicioNombre,
        os.nPrioridadId, pr.cNombre AS cPrioridadNombre, pr.cColor AS cPrioridadColor,
        os.nEstadoOrdenId, eo.cEstadoOrdenCod, eo.cNombre AS cEstadoOrdenNombre, eo.cColor AS cEstadoOrdenColor,
        os.cTitulo, os.dFechaInicio, os.dFechaFin,
        os.nPersonalLiderId, pl.cNombres + ' ' + pl.cApellidoPaterno AS cPersonalLiderNombre,
        os.nCostoEstimado,
        (SELECT COUNT(*) FROM OrdenServicioPersonal osp WHERE osp.nOrdenServicioId = os.nOrdenServicioId AND osp.bActivo = 1) AS nTrabajadoresAsignados
    FROM OrdenServicio os
    INNER JOIN Cliente c ON os.nClienteId = c.nClienteId
    INNER JOIN Persona p ON c.nPersonaId = p.nPersonaId
    INNER JOIN TipoServicio ts ON os.nTipoServicioId = ts.nTipoServicioId
    INNER JOIN Prioridad pr ON os.nPrioridadId = pr.nPrioridadId
    INNER JOIN EstadoOrden eo ON os.nEstadoOrdenId = eo.nEstadoOrdenId
    LEFT JOIN Personal pe ON os.nPersonalLiderId = pe.nPersonalId
    LEFT JOIN Persona pl ON pe.nPersonaId = pl.nPersonaId
    WHERE os.bEstado = 1
    ORDER BY os.dFechaCreacion DESC
END
