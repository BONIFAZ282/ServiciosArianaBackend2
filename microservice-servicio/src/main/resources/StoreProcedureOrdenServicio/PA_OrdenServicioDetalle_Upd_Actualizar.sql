
/*---------------------------------------------------------------------------------
PROPÓSITO          | Actualiza un servicio de una orden
---------------------------------------------------------------------------------*/
IF OBJECT_ID('PA_OrdenServicioDetalle_Upd_Actualizar') IS NOT NULL
    DROP PROCEDURE PA_OrdenServicioDetalle_Upd_Actualizar
GO

CREATE PROCEDURE PA_OrdenServicioDetalle_Upd_Actualizar(
    @nOrdenServicioDetalleId INT,
    @cDescripcion            VARCHAR(300),
    @nCantidad               INT,
    @nPrecioUnitario         DECIMAL(10,2)
)
AS
BEGIN
    SET NOCOUNT ON
    BEGIN TRY
        BEGIN TRAN
            IF NOT EXISTS (SELECT 1 FROM OrdenServicioDetalle WHERE nOrdenServicioDetalleId = @nOrdenServicioDetalleId AND bEstado = 1)
            BEGIN
                RAISERROR('El detalle no existe', 16, 1)
                RETURN
            END

            -- Validar que permite edición
            DECLARE @bPermiteEditar BIT
            SELECT @bPermiteEditar = eo.bPermiteEditar
            FROM OrdenServicioDetalle osd
            INNER JOIN OrdenServicio os ON osd.nOrdenServicioId = os.nOrdenServicioId
            INNER JOIN EstadoOrden eo ON os.nEstadoOrdenId = eo.nEstadoOrdenId
            WHERE osd.nOrdenServicioDetalleId = @nOrdenServicioDetalleId

            IF @bPermiteEditar = 0
            BEGIN
                RAISERROR('No se puede editar servicios de una orden en su estado actual', 16, 1)
                RETURN
            END

            UPDATE OrdenServicioDetalle SET
                cDescripcion = @cDescripcion,
                nCantidad = ISNULL(@nCantidad, 1),
                nPrecioUnitario = ISNULL(@nPrecioUnitario, 0)
            WHERE nOrdenServicioDetalleId = @nOrdenServicioDetalleId

            SELECT @nOrdenServicioDetalleId AS nOrdenServicioDetalleId
        COMMIT TRAN
    END TRY
    BEGIN CATCH
        IF @@TRANCOUNT > 0 ROLLBACK TRAN
        DECLARE @ErrorMessage NVARCHAR(4000) = ERROR_MESSAGE()
        RAISERROR(@ErrorMessage, 16, 1)
    END CATCH
END