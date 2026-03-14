IF OBJECT_ID('PA_Reporte_Personal_Ranking') IS NOT NULL
    DROP PROCEDURE PA_Reporte_Personal_Ranking
GO

CREATE PROCEDURE PA_Reporte_Personal_Ranking
AS
BEGIN
    SET NOCOUNT ON

    ;WITH RankingCTE AS (
        SELECT
            pe.nPersonalId,
            p.cNombres + ' ' + p.cApellidoPaterno AS cNombreCompleto,
            c.cNombre AS cCargoNombre,
            -- Como líder
            (SELECT COUNT(*) FROM OrdenServicio WHERE nPersonalLiderId = pe.nPersonalId AND bEstado = 1) AS nTotalComoLider,
            (SELECT COUNT(*) FROM OrdenServicio os
             INNER JOIN EstadoOrden eo ON os.nEstadoOrdenId = eo.nEstadoOrdenId
             WHERE os.nPersonalLiderId = pe.nPersonalId AND eo.cEstadoOrdenCod = 'RESUELTO' AND os.bEstado = 1) AS nCompletadasComoLider,
            (SELECT COUNT(*) FROM OrdenServicio os
             INNER JOIN EstadoOrden eo ON os.nEstadoOrdenId = eo.nEstadoOrdenId
             WHERE os.nPersonalLiderId = pe.nPersonalId
             AND eo.cEstadoOrdenCod IN ('PENDIENTE', 'EN_PROCESO', 'OBSERVADO') AND os.bEstado = 1) AS nActivasComoLider,
            -- Como miembro
            (SELECT COUNT(DISTINCT osp.nOrdenServicioId) FROM OrdenServicioPersonal osp
             INNER JOIN OrdenServicio os ON osp.nOrdenServicioId = os.nOrdenServicioId
             WHERE osp.nPersonalId = pe.nPersonalId AND osp.bActivo = 1 AND os.bEstado = 1) AS nTotalComoMiembro,
            (SELECT COUNT(DISTINCT osp.nOrdenServicioId) FROM OrdenServicioPersonal osp
             INNER JOIN OrdenServicio os ON osp.nOrdenServicioId = os.nOrdenServicioId
             INNER JOIN EstadoOrden eo ON os.nEstadoOrdenId = eo.nEstadoOrdenId
             WHERE osp.nPersonalId = pe.nPersonalId AND osp.bActivo = 1
             AND eo.cEstadoOrdenCod = 'RESUELTO' AND os.bEstado = 1) AS nCompletadasComoMiembro,
            (SELECT COUNT(DISTINCT osp.nOrdenServicioId) FROM OrdenServicioPersonal osp
             INNER JOIN OrdenServicio os ON osp.nOrdenServicioId = os.nOrdenServicioId
             INNER JOIN EstadoOrden eo ON os.nEstadoOrdenId = eo.nEstadoOrdenId
             WHERE osp.nPersonalId = pe.nPersonalId AND osp.bActivo = 1
             AND eo.cEstadoOrdenCod IN ('PENDIENTE', 'EN_PROCESO', 'OBSERVADO') AND os.bEstado = 1) AS nActivasComoMiembro
        FROM Personal pe
        INNER JOIN Persona p ON pe.nPersonaId = p.nPersonaId
        INNER JOIN Cargo c ON pe.nCargoId = c.nCargoId
        WHERE pe.bEstado = 1
    )
    SELECT *
    FROM RankingCTE
    ORDER BY (nCompletadasComoLider + nCompletadasComoMiembro) DESC,
             (nTotalComoLider + nTotalComoMiembro) DESC
END
GO