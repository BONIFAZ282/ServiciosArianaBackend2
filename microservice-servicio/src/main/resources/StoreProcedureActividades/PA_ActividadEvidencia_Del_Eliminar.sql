IF OBJECT_ID('PA_ActividadEvidencia_Del_Eliminar') IS NOT NULL
    DROP PROCEDURE PA_ActividadEvidencia_Del_Eliminar
GO

CREATE PROCEDURE PA_ActividadEvidencia_Del_Eliminar(
    @nActividadEvidenciaId INT
)
AS
BEGIN
    SET NOCOUNT ON
    BEGIN TRY
        BEGIN TRAN
            IF NOT EXISTS (SELECT 1 FROM ActividadEvidencia WHERE nActividadEvidenciaId = @nActividadEvidenciaId AND bEstado = 1)
            BEGIN
                RAISERROR('La evidencia no existe', 16, 1)
                RETURN
            END

            UPDATE ActividadEvidencia SET bEstado = 0 WHERE nActividadEvidenciaId = @nActividadEvidenciaId

            SELECT @nActividadEvidenciaId AS nActividadEvidenciaId
        COMMIT TRAN
    END TRY
    BEGIN CATCH
        IF @@TRANCOUNT > 0 ROLLBACK TRAN
        DECLARE @ErrorMessage NVARCHAR(4000) = ERROR_MESSAGE()
        RAISERROR(@ErrorMessage, 16, 1)
    END CATCH
END