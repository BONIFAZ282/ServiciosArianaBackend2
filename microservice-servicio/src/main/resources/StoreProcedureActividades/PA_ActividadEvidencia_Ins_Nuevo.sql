IF OBJECT_ID('PA_ActividadEvidencia_Ins_Nuevo') IS NOT NULL
    DROP PROCEDURE PA_ActividadEvidencia_Ins_Nuevo
GO

CREATE PROCEDURE PA_ActividadEvidencia_Ins_Nuevo(
    @nActividadId       INT,
    @cNombreArchivo     VARCHAR(200),
    @cRutaArchivo       VARCHAR(MAX),
    @cTipoArchivo       VARCHAR(100),
    @nTamano            INT
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

            INSERT INTO ActividadEvidencia (nActividadId, cNombreArchivo, cRutaArchivo, cTipoArchivo, nTamano)
            VALUES (@nActividadId, @cNombreArchivo, @cRutaArchivo, @cTipoArchivo, @nTamano)

            SELECT SCOPE_IDENTITY() AS nActividadEvidenciaId
        COMMIT TRAN
    END TRY
    BEGIN CATCH
        IF @@TRANCOUNT > 0 ROLLBACK TRAN
        DECLARE @ErrorMessage NVARCHAR(4000) = ERROR_MESSAGE()
        RAISERROR(@ErrorMessage, 16, 1)
    END CATCH
END