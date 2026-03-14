CREATE PROCEDURE PA_TipoServicio_Ins_Nuevo(
    @cTipoServicioCod   VARCHAR(20),
    @cNombre            VARCHAR(100),
    @cDescripcion       VARCHAR(250),
    @nPrecioBase        DECIMAL(10,2)
)
AS
BEGIN
    SET NOCOUNT ON
    BEGIN TRY
        BEGIN TRAN
            IF EXISTS (SELECT 1 FROM TipoServicio WHERE cTipoServicioCod = @cTipoServicioCod)
            BEGIN
                RAISERROR('Ya existe un tipo de servicio con este código', 16, 1)
                RETURN
            END

            INSERT INTO TipoServicio (cTipoServicioCod, cNombre, cDescripcion, nPrecioBase)
            VALUES (@cTipoServicioCod, @cNombre, @cDescripcion, @nPrecioBase)

            SELECT SCOPE_IDENTITY() AS nTipoServicioId
        COMMIT TRAN
    END TRY
    BEGIN CATCH
        IF @@TRANCOUNT > 0 ROLLBACK TRAN
        DECLARE @ErrorMessage NVARCHAR(4000) = ERROR_MESSAGE()
        RAISERROR(@ErrorMessage, 16, 1)
    END CATCH
END