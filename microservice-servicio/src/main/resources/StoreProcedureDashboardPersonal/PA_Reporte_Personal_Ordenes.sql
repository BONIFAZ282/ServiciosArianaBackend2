IF OBJECT_ID('PA_Reporte_Personal_Ordenes') IS NOT NULL
    DROP PROCEDURE PA_Reporte_Personal_Ordenes
GO

CREATE PROCEDURE PA_Reporte_Personal_Ordenes(
    @nPersonalId INT
)
AS
BEGIN
    SET NOCOUNT ON
    
    ;WITH OrdenesPersonal AS (
        -- Órdenes como líder
        SELECT 
            os.nOrdenServicioId,
            os.cOrdenServicioCod,
            os.cTitulo,
            COALESCE(c.cRazonSocial, p.cNombres + ' ' + p.cApellidoPaterno) AS cClienteNombre,
            eo.cEstadoOrdenCod,
            eo.cNombre AS cEstadoNombre,
            eo.cColor AS cEstadoColor,
            pr.cNombre AS cPrioridadNombre,
            pr.cColor AS cPrioridadColor,
            os.dFechaInicio,
            os.dFechaFin,
            os.nPersonalLiderId,
            pl.cNombres + ' ' + pl.cApellidoPaterno AS cPersonalLiderNombre,
            'LIDER' AS cRol
        FROM OrdenServicio os
        INNER JOIN EstadoOrden eo ON os.nEstadoOrdenId = eo.nEstadoOrdenId
        INNER JOIN Prioridad pr ON os.nPrioridadId = pr.nPrioridadId
        INNER JOIN Cliente c ON os.nClienteId = c.nClienteId
        INNER JOIN Persona p ON c.nPersonaId = p.nPersonaId
        LEFT JOIN Personal pel ON os.nPersonalLiderId = pel.nPersonalId
        LEFT JOIN Persona pl ON pel.nPersonaId = pl.nPersonaId
        WHERE os.nPersonalLiderId = @nPersonalId AND os.bEstado = 1

        UNION ALL

        -- Órdenes como miembro
        SELECT
            os.nOrdenServicioId,
            os.cOrdenServicioCod,
            os.cTitulo,
            COALESCE(c.cRazonSocial, p.cNombres + ' ' + p.cApellidoPaterno) AS cClienteNombre,
            eo.cEstadoOrdenCod,
            eo.cNombre AS cEstadoNombre,
            eo.cColor AS cEstadoColor,
            pr.cNombre AS cPrioridadNombre,
            pr.cColor AS cPrioridadColor,
            os.dFechaInicio,
            os.dFechaFin,
            os.nPersonalLiderId,
            pl.cNombres + ' ' + pl.cApellidoPaterno AS cPersonalLiderNombre,
            'MIEMBRO' AS cRol
        FROM OrdenServicioPersonal osp
        INNER JOIN OrdenServicio os ON osp.nOrdenServicioId = os.nOrdenServicioId
        INNER JOIN EstadoOrden eo ON os.nEstadoOrdenId = eo.nEstadoOrdenId
        INNER JOIN Prioridad pr ON os.nPrioridadId = pr.nPrioridadId
        INNER JOIN Cliente c ON os.nClienteId = c.nClienteId
        INNER JOIN Persona p ON c.nPersonaId = p.nPersonaId
        LEFT JOIN Personal pel ON os.nPersonalLiderId = pel.nPersonalId
        LEFT JOIN Persona pl ON pel.nPersonaId = pl.nPersonaId
        WHERE osp.nPersonalId = @nPersonalId AND osp.bActivo = 1 AND os.bEstado = 1
        AND os.nPersonalLiderId != @nPersonalId
    )
    SELECT 
        op.*,
        (SELECT STRING_AGG(ts.cNombre, ', ') 
         FROM OrdenServicioDetalle osd 
         INNER JOIN TipoServicio ts ON osd.nTipoServicioId = ts.nTipoServicioId
         WHERE osd.nOrdenServicioId = op.nOrdenServicioId AND osd.bEstado = 1) AS cTipoServicioNombre
    FROM OrdenesPersonal op
    ORDER BY op.dFechaInicio DESC
END
GO