IF OBJECT_ID('PA_Actividad_Ins_Nuevo') IS NOT NULL
    DROP PROCEDURE PA_Actividad_Ins_Nuevo
GO

CREATE PROCEDURE PA_Actividad_Ins_Nuevo(
    @nOrdenServicioId   INT,
    @nPersonalId        INT,
    @cTitulo            VARCHAR(200),
    @cDescripcion       VARCHAR(500),
    @dFechaActividad    DATE
)
AS
BEGIN
    SET NOCOUNT ON
    BEGIN TRY
        BEGIN TRAN
            -- Validar que la orden existe y está activa
            IF NOT EXISTS (SELECT 1 FROM OrdenServicio WHERE nOrdenServicioId = @nOrdenServicioId AND bEstado = 1)
            BEGIN
                RAISERROR('La orden de servicio no existe o está inactiva', 16, 1)
                RETURN
            END

            -- Validar que la orden permite registro de actividades (no finalizada/cancelada)
            DECLARE @cEstadoOrdenCod VARCHAR(20)
            SELECT @cEstadoOrdenCod = eo.cEstadoOrdenCod
            FROM OrdenServicio os
            INNER JOIN EstadoOrden eo ON os.nEstadoOrdenId = eo.nEstadoOrdenId
            WHERE os.nOrdenServicioId = @nOrdenServicioId

            IF @cEstadoOrdenCod IN ('RESUELTO', 'CANCELADO')
            BEGIN
                RAISERROR('No se pueden registrar actividades en una orden finalizada o cancelada', 16, 1)
                RETURN
            END

            -- Validar que el personal existe
            IF NOT EXISTS (SELECT 1 FROM Personal WHERE nPersonalId = @nPersonalId AND bEstado = 1)
            BEGIN
                RAISERROR('El personal no existe o está inactivo', 16, 1)
                RETURN
            END

            -- Validar que el personal está asignado a la orden (como líder o miembro)
            DECLARE @bEsLider BIT = 0, @bEsMiembro BIT = 0

            IF EXISTS (SELECT 1 FROM OrdenServicio WHERE nOrdenServicioId = @nOrdenServicioId AND nPersonalLiderId = @nPersonalId)
                SET @bEsLider = 1

            IF EXISTS (SELECT 1 FROM OrdenServicioPersonal WHERE nOrdenServicioId = @nOrdenServicioId AND nPersonalId = @nPersonalId AND bActivo = 1)
                SET @bEsMiembro = 1

            IF @bEsLider = 0 AND @bEsMiembro = 0
            BEGIN
                RAISERROR('El personal no está asignado a esta orden de servicio', 16, 1)
                RETURN
            END

            INSERT INTO Actividad (nOrdenServicioId, nPersonalId, cTitulo, cDescripcion, dFechaActividad)
            VALUES (@nOrdenServicioId, @nPersonalId, @cTitulo, @cDescripcion, @dFechaActividad)

            SELECT SCOPE_IDENTITY() AS nActividadId
        COMMIT TRAN
    END TRY
    BEGIN CATCH
        IF @@TRANCOUNT > 0 ROLLBACK TRAN
        DECLARE @ErrorMessage NVARCHAR(4000) = ERROR_MESSAGE()
        RAISERROR(@ErrorMessage, 16, 1)
    END CATCH
END