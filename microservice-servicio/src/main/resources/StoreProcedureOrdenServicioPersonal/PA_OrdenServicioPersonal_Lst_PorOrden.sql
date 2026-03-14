
CREATE PROCEDURE PA_OrdenServicioPersonal_Lst_PorOrden(
    @nOrdenServicioId INT
)
AS
BEGIN
    SET NOCOUNT ON
    SELECT
        osp.nOrdenServicioPersonalId, osp.nOrdenServicioId, osp.nPersonalId,
        p.cNombres + ' ' + p.cApellidoPaterno AS cPersonalNombre,
        p.cTelefono, p.cEmail, c.cNombre AS cCargoNombre,
        osp.dFechaAsignacion, osp.cObservaciones, osp.bActivo
    FROM OrdenServicioPersonal osp
    INNER JOIN Personal pe ON osp.nPersonalId = pe.nPersonalId
    INNER JOIN Persona p ON pe.nPersonaId = p.nPersonaId
    INNER JOIN Cargo c ON pe.nCargoId = c.nCargoId
    WHERE osp.nOrdenServicioId = @nOrdenServicioId AND osp.bActivo = 1
    ORDER BY osp.dFechaAsignacion
END