IF OBJECT_ID('PA_Alerta_Get_PorId') IS NOT NULL
    DROP PROCEDURE PA_Alerta_Get_PorId
GO

CREATE PROCEDURE PA_Alerta_Get_PorId(
    @nAlertaId INT
)
AS
BEGIN
    SET NOCOUNT ON
    SELECT
        a.nAlertaId,
        a.nOrdenServicioId,
        os.cOrdenServicioCod,
        os.cTitulo AS cOrdenTitulo,
        COALESCE(c.cRazonSocial, p.cNombres + ' ' + p.cApellidoPaterno) AS cClienteNombre,
        a.nTipoAlertaId,
        ta.cTipoAlertaCod,
        ta.cNombre AS cTipoAlertaNombre,
        ta.cColor AS cTipoAlertaColor,
        a.cMensaje,
        a.dFechaGeneracion,
        a.bLeida,
        a.dFechaLectura,
        os.nPersonalLiderId,
        pl.cNombres + ' ' + pl.cApellidoPaterno AS cPersonalLiderNombre,
        os.dFechaFin,
        pr.cNombre AS cPrioridadNombre,
        pr.cColor AS cPrioridadColor,
        eo.cNombre AS cEstadoOrdenNombre,
        eo.cColor AS cEstadoOrdenColor
    FROM Alerta a
    INNER JOIN OrdenServicio os ON a.nOrdenServicioId = os.nOrdenServicioId
    INNER JOIN TipoAlerta ta ON a.nTipoAlertaId = ta.nTipoAlertaId
    INNER JOIN Cliente c ON os.nClienteId = c.nClienteId
    INNER JOIN Persona p ON c.nPersonaId = p.nPersonaId
    INNER JOIN Prioridad pr ON os.nPrioridadId = pr.nPrioridadId
    INNER JOIN EstadoOrden eo ON os.nEstadoOrdenId = eo.nEstadoOrdenId
    LEFT JOIN Personal pe ON os.nPersonalLiderId = pe.nPersonalId
    LEFT JOIN Persona pl ON pe.nPersonaId = pl.nPersonaId
    WHERE a.nAlertaId = @nAlertaId AND a.bEstado = 1
END