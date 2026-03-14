CREATE PROCEDURE PA_OrdenServicio_Lst_EquipoPorLider(
    @nPersonalLiderId INT
)
AS
BEGIN
    SET NOCOUNT ON

    SELECT
        os.nOrdenServicioId,
        os.cOrdenServicioCod,
        os.cTitulo,
        eo.cNombre AS cEstadoOrdenNombre,
        eo.cColor AS cEstadoOrdenColor,
        os.dFechaInicio,
        os.dFechaFin,
        osp.nPersonalId AS nTrabajadorId,
        p.cNombres + ' ' + p.cApellidoPaterno AS cTrabajadorNombre,
        c.cNombre AS cTrabajadorCargo,
        p.cTelefono AS cTrabajadorTelefono,
        osp.dFechaAsignacion
    FROM OrdenServicio os
    INNER JOIN EstadoOrden eo ON os.nEstadoOrdenId = eo.nEstadoOrdenId
    LEFT JOIN OrdenServicioPersonal osp ON os.nOrdenServicioId = osp.nOrdenServicioId AND osp.bActivo = 1
    LEFT JOIN Personal pe ON osp.nPersonalId = pe.nPersonalId
    LEFT JOIN Persona p ON pe.nPersonaId = p.nPersonaId
    LEFT JOIN Cargo c ON pe.nCargoId = c.nCargoId
    WHERE os.nPersonalLiderId = @nPersonalLiderId
    AND os.bEstado = 1
    AND eo.cEstadoOrdenCod NOT IN ('RESUELTO', 'CANCELADO')
    ORDER BY os.dFechaInicio, os.nOrdenServicioId, p.cApellidoPaterno
END