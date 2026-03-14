
CREATE PROCEDURE PA_OrdenServicioPersonal_Ins_Asignar(
    @nOrdenServicioId   INT,
    @nPersonalId        INT,
    @cObservaciones     VARCHAR(300)
)
AS
BEGIN
    SET NOCOUNT ON
    BEGIN TRY
        BEGIN TRAN
            IF NOT EXISTS (SELECT 1 FROM OrdenServicio WHERE nOrdenServicioId = @nOrdenServicioId AND bEstado = 1)
            BEGIN
                RAISERROR('La orden de servicio no existe o está inactiva', 16, 1)
                RETURN
            END

            DECLARE @bPermiteEditar BIT
            SELECT @bPermiteEditar = eo.bPermiteEditar
            FROM OrdenServicio os
            INNER JOIN EstadoOrden eo ON os.nEstadoOrdenId = eo.nEstadoOrdenId
            WHERE os.nOrdenServicioId = @nOrdenServicioId

            IF @bPermiteEditar = 0
            BEGIN
                RAISERROR('No se pueden asignar trabajadores a una orden en su estado actual', 16, 1)
                RETURN
            END

            IF NOT EXISTS (SELECT 1 FROM Personal WHERE nPersonalId = @nPersonalId AND bEstado = 1)
            BEGIN
                RAISERROR('El personal no existe o está inactivo', 16, 1)
                RETURN
            END

            IF EXISTS (SELECT 1 FROM OrdenServicioPersonal WHERE nOrdenServicioId = @nOrdenServicioId AND nPersonalId = @nPersonalId AND bActivo = 1)
            BEGIN
                RAISERROR('El trabajador ya está asignado a esta orden', 16, 1)
                RETURN
            END

            -- Si existía pero fue desasignado, reactivar
            IF EXISTS (SELECT 1 FROM OrdenServicioPersonal WHERE nOrdenServicioId = @nOrdenServicioId AND nPersonalId = @nPersonalId AND bActivo = 0)
            BEGIN
                UPDATE OrdenServicioPersonal SET
                    bActivo = 1, dFechaAsignacion = GETDATE(), dFechaDesasignacion = NULL, cObservaciones = @cObservaciones
                WHERE nOrdenServicioId = @nOrdenServicioId AND nPersonalId = @nPersonalId

                SELECT (SELECT nOrdenServicioPersonalId FROM OrdenServicioPersonal WHERE nOrdenServicioId = @nOrdenServicioId AND nPersonalId = @nPersonalId) AS nOrdenServicioPersonalId
            END
            ELSE
            BEGIN
                INSERT INTO OrdenServicioPersonal (nOrdenServicioId, nPersonalId, cObservaciones)
                VALUES (@nOrdenServicioId, @nPersonalId, @cObservaciones)

                SELECT SCOPE_IDENTITY() AS nOrdenServicioPersonalId
            END
        COMMIT TRAN
    END TRY
    BEGIN CATCH
        IF @@TRANCOUNT > 0 ROLLBACK TRAN
        DECLARE @ErrorMessage NVARCHAR(4000) = ERROR_MESSAGE()
        RAISERROR(@ErrorMessage, 16, 1)
    END CATCH
END