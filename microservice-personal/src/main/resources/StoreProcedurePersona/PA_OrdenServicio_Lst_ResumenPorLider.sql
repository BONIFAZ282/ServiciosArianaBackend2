CREATE PROCEDURE PA_OrdenServicio_Lst_ResumenPorLider(
    @nPersonalLiderId INT
)
AS
BEGIN
    SET NOCOUNT ON

    SELECT
        os.nOrdenServicioId,
        os.cOrdenServicioCod,
        os.cTitulo,
        COALESCE(cl.cRazonSocial, pc.cNombres + ' ' + pc.cApellidoPaterno) AS cClienteNombre,
        eo.cNombre AS cEstadoOrdenNombre,
        eo.cColor AS cEstadoOrdenColor,
        pr.cNombre AS cPrioridadNombre,
        pr.cColor AS cPrioridadColor,
        os.dFechaInicio,
        os.dFechaFin,
        (SELECT COUNT(*) FROM OrdenServicioPersonal osp WHERE osp.nOrdenServicioId = os.nOrdenServicioId AND osp.bActivo = 1) AS nTotalTrabajadores,
        (SELECT COUNT(*) FROM OrdenServicioDetalle osd WHERE osd.nOrdenServicioId = os.nOrdenServicioId AND osd.bEstado = 1) AS nTotalServicios
    FROM OrdenServicio os
    INNER JOIN EstadoOrden eo ON os.nEstadoOrdenId = eo.nEstadoOrdenId
    INNER JOIN Prioridad pr ON os.nPrioridadId = pr.nPrioridadId
    INNER JOIN Cliente cl ON os.nClienteId = cl.nClienteId
    INNER JOIN Persona pc ON cl.nPersonaId = pc.nPersonaId
    WHERE os.nPersonalLiderId = @nPersonalLiderId
    AND os.bEstado = 1
    ORDER BY
        CASE eo.cEstadoOrdenCod
            WHEN 'EN_PROCESO' THEN 1
            WHEN 'PENDIENTE' THEN 2
            WHEN 'OBSERVADO' THEN 3
            ELSE 4
        END,
        os.dFechaInicio
END