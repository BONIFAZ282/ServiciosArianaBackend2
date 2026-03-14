/*---------------------------------------------------------------------------------
PROPÓSITO          | Carga de trabajo actual por trabajador
---------------------------------------------------------------------------------*/
IF OBJECT_ID('PA_Reporte_Personal_CargaTrabajo') IS NOT NULL
    DROP PROCEDURE PA_Reporte_Personal_CargaTrabajo
GO

CREATE PROCEDURE PA_Reporte_Personal_CargaTrabajo
AS
BEGIN
    SET NOCOUNT ON
    SELECT
        pe.nPersonalId,
        p.cNombres + ' ' + p.cApellidoPaterno AS cNombreCompleto,
        c.cNombre AS cCargoNombre,
        -- Carga como líder
        (SELECT COUNT(*) FROM OrdenServicio os
         INNER JOIN EstadoOrden eo ON os.nEstadoOrdenId = eo.nEstadoOrdenId
         WHERE os.nPersonalLiderId = pe.nPersonalId
         AND eo.cEstadoOrdenCod IN ('PENDIENTE', 'EN_PROCESO', 'OBSERVADO') AND os.bEstado = 1) AS nCargaComoLider,
        -- Carga como miembro
        (SELECT COUNT(DISTINCT osp.nOrdenServicioId) FROM OrdenServicioPersonal osp
         INNER JOIN OrdenServicio os ON osp.nOrdenServicioId = os.nOrdenServicioId
         INNER JOIN EstadoOrden eo ON os.nEstadoOrdenId = eo.nEstadoOrdenId
         WHERE osp.nPersonalId = pe.nPersonalId AND osp.bActivo = 1
         AND eo.cEstadoOrdenCod IN ('PENDIENTE', 'EN_PROCESO', 'OBSERVADO') AND os.bEstado = 1) AS nCargaComoMiembro
    FROM Personal pe
    INNER JOIN Persona p ON pe.nPersonaId = p.nPersonaId
    INNER JOIN Cargo c ON pe.nCargoId = c.nCargoId
    WHERE pe.bEstado = 1
    ORDER BY (
        (SELECT COUNT(*) FROM OrdenServicio os
         INNER JOIN EstadoOrden eo ON os.nEstadoOrdenId = eo.nEstadoOrdenId
         WHERE os.nPersonalLiderId = pe.nPersonalId
         AND eo.cEstadoOrdenCod IN ('PENDIENTE', 'EN_PROCESO', 'OBSERVADO') AND os.bEstado = 1)
    ) DESC
END