
CREATE PROCEDURE PA_OrdenServicioPersonal_Upd_Desasignar(
    @nOrdenServicioId   INT,
    @nPersonalId        INT
)
AS
BEGIN
    SET NOCOUNT ON
    BEGIN TRY
        BEGIN TRAN
            IF NOT EXISTS (SELECT 1 FROM OrdenServicioPersonal WHERE nOrdenServicioId = @nOrdenServicioId AND nPersonalId = @nPersonalId AND bActivo = 1)
            BEGIN
                RAISERROR('El trabajador no está asignado a esta orden', 16, 1)
                RETURN
            END

            UPDATE OrdenServicioPersonal SET bActivo = 0, dFechaDesasignacion = GETDATE()
            WHERE nOrdenServicioId = @nOrdenServicioId AND nPersonalId = @nPersonalId

            SELECT @nOrdenServicioId AS nOrdenServicioId, @nPersonalId AS nPersonalId
        COMMIT TRAN
    END TRY
    BEGIN CATCH
        IF @@TRANCOUNT > 0 ROLLBACK TRAN
        DECLARE @ErrorMessage NVARCHAR(4000) = ERROR_MESSAGE()
        RAISERROR(@ErrorMessage, 16, 1)
    END CATCH
END