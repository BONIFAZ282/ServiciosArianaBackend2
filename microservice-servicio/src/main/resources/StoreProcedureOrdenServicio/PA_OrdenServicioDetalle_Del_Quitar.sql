
/*---------------------------------------------------------------------------------
PROPÓSITO          | Elimina un servicio de una orden
---------------------------------------------------------------------------------*/
IF OBJECT_ID('PA_OrdenServicioDetalle_Del_Quitar') IS NOT NULL
    DROP PROCEDURE PA_OrdenServicioDetalle_Del_Quitar
GO

CREATE PROCEDURE PA_OrdenServicioDetalle_Del_Quitar(
    @nOrdenServicioDetalleId INT
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
                RAISERROR('No se puede quitar servicios de una orden en su estado actual', 16, 1)
                RETURN
            END

            UPDATE OrdenServicioDetalle SET bEstado = 0 WHERE nOrdenServicioDetalleId = @nOrdenServicioDetalleId

            SELECT @nOrdenServicioDetalleId AS nOrdenServicioDetalleId
        COMMIT TRAN
    END TRY
    BEGIN CATCH
        IF @@TRANCOUNT > 0 ROLLBACK TRAN
        DECLARE @ErrorMessage NVARCHAR(4000) = ERROR_MESSAGE()
        RAISERROR(@ErrorMessage, 16, 1)
    END CATCH
END