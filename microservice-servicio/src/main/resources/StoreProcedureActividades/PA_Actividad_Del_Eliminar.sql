IF OBJECT_ID('PA_Actividad_Del_Eliminar') IS NOT NULL
    DROP PROCEDURE PA_Actividad_Del_Eliminar
GO

CREATE PROCEDURE PA_Actividad_Del_Eliminar(
    @nActividadId INT
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

            -- Eliminar evidencias asociadas
            UPDATE ActividadEvidencia SET bEstado = 0 WHERE nActividadId = @nActividadId

            -- Eliminar actividad
            UPDATE Actividad SET bEstado = 0 WHERE nActividadId = @nActividadId

            SELECT @nActividadId AS nActividadId
        COMMIT TRAN
    END TRY
    BEGIN CATCH
        IF @@TRANCOUNT > 0 ROLLBACK TRAN
        DECLARE @ErrorMessage NVARCHAR(4000) = ERROR_MESSAGE()
        RAISERROR(@ErrorMessage, 16, 1)
    END CATCH
END