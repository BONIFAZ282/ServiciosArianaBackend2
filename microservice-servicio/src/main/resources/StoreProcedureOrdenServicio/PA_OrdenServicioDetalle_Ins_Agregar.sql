/*---------------------------------------------------------------------------------
PROPÓSITO          | Agrega un servicio a una orden
---------------------------------------------------------------------------------*/
IF OBJECT_ID('PA_OrdenServicioDetalle_Ins_Agregar') IS NOT NULL
    DROP PROCEDURE PA_OrdenServicioDetalle_Ins_Agregar
GO

CREATE PROCEDURE PA_OrdenServicioDetalle_Ins_Agregar(
    @nOrdenServicioId   INT,
    @nTipoServicioId    INT,
    @cDescripcion       VARCHAR(300),
    @nCantidad          INT,
    @nPrecioUnitario    DECIMAL(10,2)
)
AS
BEGIN
    SET NOCOUNT ON
    BEGIN TRY
        BEGIN TRAN
            -- Validar que la orden existe
            IF NOT EXISTS (SELECT 1 FROM OrdenServicio WHERE nOrdenServicioId = @nOrdenServicioId AND bEstado = 1)
            BEGIN
                RAISERROR('La orden de servicio no existe o está inactiva', 16, 1)
                RETURN
            END

            -- Validar que permite edición
            DECLARE @bPermiteEditar BIT
            SELECT @bPermiteEditar = eo.bPermiteEditar
            FROM OrdenServicio os
            INNER JOIN EstadoOrden eo ON os.nEstadoOrdenId = eo.nEstadoOrdenId
            WHERE os.nOrdenServicioId = @nOrdenServicioId

            IF @bPermiteEditar = 0
            BEGIN
                RAISERROR('No se pueden agregar servicios a una orden en su estado actual', 16, 1)
                RETURN
            END

            -- Validar que el tipo de servicio existe
            IF NOT EXISTS (SELECT 1 FROM TipoServicio WHERE nTipoServicioId = @nTipoServicioId AND bEstado = 1)
            BEGIN
                RAISERROR('El tipo de servicio no existe o está inactivo', 16, 1)
                RETURN
            END

            -- Validar que no esté duplicado
            IF EXISTS (SELECT 1 FROM OrdenServicioDetalle WHERE nOrdenServicioId = @nOrdenServicioId AND nTipoServicioId = @nTipoServicioId AND bEstado = 1)
            BEGIN
                RAISERROR('Este servicio ya está agregado a la orden', 16, 1)
                RETURN
            END

            INSERT INTO OrdenServicioDetalle (nOrdenServicioId, nTipoServicioId, cDescripcion, nCantidad, nPrecioUnitario)
            VALUES (@nOrdenServicioId, @nTipoServicioId, @cDescripcion, ISNULL(@nCantidad, 1), ISNULL(@nPrecioUnitario, 0))

            SELECT SCOPE_IDENTITY() AS nOrdenServicioDetalleId
        COMMIT TRAN
    END TRY
    BEGIN CATCH
        IF @@TRANCOUNT > 0 ROLLBACK TRAN
        DECLARE @ErrorMessage NVARCHAR(4000) = ERROR_MESSAGE()
        RAISERROR(@ErrorMessage, 16, 1)
    END CATCH
END
