IF OBJECT_ID('PA_Actividad_Upd_Actualizar') IS NOT NULL
    DROP PROCEDURE PA_Actividad_Upd_Actualizar
GO

CREATE PROCEDURE PA_Actividad_Upd_Actualizar(
    @nActividadId       INT,
    @cTitulo            VARCHAR(200),
    @cDescripcion       VARCHAR(500),
    @dFechaActividad    DATE
)
AS
BEGIN
    SET NOCOUNT ON
    BEGIN TRY
        BEGIN TRAN
            IF NOT EXISTS (SELECT 1 FROM Actividad WHERE nActividadId = @nActividadId AND bEstado = 1)
            BEGIN
                RAISERROR('La actividad no existe', 16, 1)
                RETURN
            END

            -- Validar que la orden aún permite edición
            DECLARE @cEstadoOrdenCod VARCHAR(20)
            SELECT @cEstadoOrdenCod = eo.cEstadoOrdenCod
            FROM Actividad a
            INNER JOIN OrdenServicio os ON a.nOrdenServicioId = os.nOrdenServicioId
            INNER JOIN EstadoOrden eo ON os.nEstadoOrdenId = eo.nEstadoOrdenId
            WHERE a.nActividadId = @nActividadId

            IF @cEstadoOrdenCod IN ('RESUELTO', 'CANCELADO')
            BEGIN
                RAISERROR('No se pueden editar actividades de una orden finalizada o cancelada', 16, 1)
                RETURN
            END

            UPDATE Actividad SET
                cTitulo = @cTitulo,
                cDescripcion = @cDescripcion,
                dFechaActividad = @dFechaActividad
            WHERE nActividadId = @nActividadId

            SELECT @nActividadId AS nActividadId
        COMMIT TRAN
    END TRY
    BEGIN CATCH
        IF @@TRANCOUNT > 0 ROLLBACK TRAN
        DECLARE @ErrorMessage NVARCHAR(4000) = ERROR_MESSAGE()
        RAISERROR(@ErrorMessage, 16, 1)
    END CATCH
END