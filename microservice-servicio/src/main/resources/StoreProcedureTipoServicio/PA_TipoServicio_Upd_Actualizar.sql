CREATE PROCEDURE PA_TipoServicio_Upd_Actualizar(
    @nTipoServicioId    INT,
    @cTipoServicioCod   VARCHAR(20),
    @cNombre            VARCHAR(100),
    @cDescripcion       VARCHAR(250),
    @nPrecioBase        DECIMAL(10,2),
    @bEstado            BIT
)
AS
BEGIN
    SET NOCOUNT ON
    BEGIN TRY
        BEGIN TRAN
            IF NOT EXISTS (SELECT 1 FROM TipoServicio WHERE nTipoServicioId = @nTipoServicioId)
            BEGIN
                RAISERROR('El tipo de servicio no existe', 16, 1)
                RETURN
            END

            UPDATE TipoServicio SET
                cTipoServicioCod = @cTipoServicioCod,
                cNombre = @cNombre,
                cDescripcion = @cDescripcion,
                nPrecioBase = @nPrecioBase,
                bEstado = @bEstado
            WHERE nTipoServicioId = @nTipoServicioId

            SELECT @nTipoServicioId AS nTipoServicioId
        COMMIT TRAN
    END TRY
    BEGIN CATCH
        IF @@TRANCOUNT > 0 ROLLBACK TRAN
        DECLARE @ErrorMessage NVARCHAR(4000) = ERROR_MESSAGE()
        RAISERROR(@ErrorMessage, 16, 1)
    END CATCH
END