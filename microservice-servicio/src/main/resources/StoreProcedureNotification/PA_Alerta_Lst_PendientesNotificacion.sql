/*---------------------------------------------------------------------------------
PROPÓSITO          | Lista alertas pendientes de notificación por email
---------------------------------------------------------------------------------*/
IF OBJECT_ID('PA_Alerta_Lst_PendientesNotificacion') IS NOT NULL
    DROP PROCEDURE PA_Alerta_Lst_PendientesNotificacion
GO

CREATE PROCEDURE PA_Alerta_Lst_PendientesNotificacion
AS
BEGIN
    SET NOCOUNT ON
    SELECT
        a.nAlertaId,
        a.nOrdenServicioId,
        os.cOrdenServicioCod,
        os.cTitulo AS cOrdenTitulo,
        ta.cTipoAlertaCod,
        ta.cNombre AS cTipoAlertaNombre,
        a.cMensaje,
        a.dFechaGeneracion,
        os.dFechaFin,
        CASE
            WHEN os.dFechaFin < CAST(GETDATE() AS DATE) THEN DATEDIFF(DAY, os.dFechaFin, GETDATE())
            ELSE DATEDIFF(DAY, GETDATE(), os.dFechaFin)
        END AS nDias,
        os.nPersonalLiderId,
        pl.cNombres + ' ' + pl.cApellidoPaterno AS cPersonalLiderNombre,
        pl.cEmail AS cPersonalLiderEmail,
        pr.cNombre AS cPrioridadNombre,
        COALESCE(c.cRazonSocial, pc.cNombres + ' ' + pc.cApellidoPaterno) AS cClienteNombre
    FROM Alerta a
    INNER JOIN OrdenServicio os ON a.nOrdenServicioId = os.nOrdenServicioId
    INNER JOIN TipoAlerta ta ON a.nTipoAlertaId = ta.nTipoAlertaId
    INNER JOIN Prioridad pr ON os.nPrioridadId = pr.nPrioridadId
    INNER JOIN Cliente c ON os.nClienteId = c.nClienteId
    INNER JOIN Persona pc ON c.nPersonaId = pc.nPersonaId
    LEFT JOIN Personal pe ON os.nPersonalLiderId = pe.nPersonalId
    LEFT JOIN Persona pl ON pe.nPersonaId = pl.nPersonaId
    WHERE a.bEstado = 1
    AND a.bNotificadoEmail = 0
    AND pl.cEmail IS NOT NULL
    AND pl.cEmail != ''
    ORDER BY a.dFechaGeneracion
END