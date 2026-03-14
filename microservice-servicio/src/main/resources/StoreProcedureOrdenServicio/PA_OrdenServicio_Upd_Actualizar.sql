
CREATE PROCEDURE PA_OrdenServicio_Upd_Actualizar(
    @nOrdenServicioId   INT,
    @nClienteId         INT,
    @nTipoServicioId    INT,
    @nPrioridadId       INT,
    @cTitulo            VARCHAR(200),
    @cDescripcion       VARCHAR(500),
    @dFechaInicio       DATE,
    @dFechaFin          DATE,
    @nPersonalLiderId   INT,
    @cDireccionServicio VARCHAR(300),
    @nCostoEstimado     DECIMAL(10,2),
    @nCostoReal         DECIMAL(10,2),
    @cObservaciones     VARCHAR(500)
)
AS
BEGIN
    SET NOCOUNT ON
    BEGIN TRY
        BEGIN TRAN
            IF NOT EXISTS (SELECT 1 FROM OrdenServicio WHERE nOrdenServicioId = @nOrdenServicioId)
            BEGIN
                RAISERROR('La orden de servicio no existe', 16, 1)
                RETURN
            END

            DECLARE @bPermiteEditar BIT
            SELECT @bPermiteEditar = eo.bPermiteEditar
            FROM OrdenServicio os
            INNER JOIN EstadoOrden eo ON os.nEstadoOrdenId = eo.nEstadoOrdenId
            WHERE os.nOrdenServicioId = @nOrdenServicioId

            IF @bPermiteEditar = 0
            BEGIN
                RAISERROR('No se puede editar la orden en su estado actual', 16, 1)
                RETURN
            END

            IF @dFechaFin < @dFechaInicio
            BEGIN
                RAISERROR('La fecha fin no puede ser menor a la fecha inicio', 16, 1)
                RETURN
            END

            UPDATE OrdenServicio SET
                nClienteId = @nClienteId, nTipoServicioId = @nTipoServicioId, nPrioridadId = @nPrioridadId,
                cTitulo = @cTitulo, cDescripcion = @cDescripcion, dFechaInicio = @dFechaInicio,
                dFechaFin = @dFechaFin, nPersonalLiderId = @nPersonalLiderId, cDireccionServicio = @cDireccionServicio,
                nCostoEstimado = @nCostoEstimado, nCostoReal = @nCostoReal, cObservaciones = @cObservaciones
            WHERE nOrdenServicioId = @nOrdenServicioId

            SELECT @nOrdenServicioId AS nOrdenServicioId
        COMMIT TRAN
    END TRY
    BEGIN CATCH
        IF @@TRANCOUNT > 0 ROLLBACK TRAN
        DECLARE @ErrorMessage NVARCHAR(4000) = ERROR_MESSAGE()
        RAISERROR(@ErrorMessage, 16, 1)
    END CATCH
END