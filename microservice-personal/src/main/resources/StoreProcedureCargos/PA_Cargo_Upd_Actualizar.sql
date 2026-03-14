/*---------------------------------------------------------------------------------
PROPÓSITO           | Actualiza un cargo existente
AUTOR               | Sibhell Dhaleska
FECHA DE CREACIÓN   | 2025-01-21
-----------------------------------------------------------------------------------
EJEMPLO:
    EXEC PA_Cargo_Upd_Actualizar 1, 'AD001', 'Administrador', 'Acceso total', 1
-----------------------------------------------------------------------------------*/
CREATE PROCEDURE PA_Cargo_Upd_Actualizar(
    @nCargoId       INT,
    @cCargoCod      VARCHAR(20),
    @cNombre        VARCHAR(100),
    @cDescripcion   VARCHAR(250),
    @bEstado        BIT
)
AS
BEGIN
    SET NOCOUNT ON
    BEGIN TRY
        BEGIN TRAN
            UPDATE Cargo SET
                cCargoCod = @cCargoCod,
                cNombre = @cNombre,
                cDescripcion = @cDescripcion,
                bEstado = @bEstado
            WHERE nCargoId = @nCargoId

        COMMIT TRAN
    END TRY
    BEGIN CATCH
        IF @@TRANCOUNT > 0
            ROLLBACK TRAN
        DECLARE @ErrorMessage NVARCHAR(4000) = ERROR_MESSAGE()
        DECLARE @ErrorSeverity INT = ERROR_SEVERITY()
        DECLARE @ErrorState INT = ERROR_STATE()
        RAISERROR(@ErrorMessage, @ErrorSeverity, @ErrorState)
    END CATCH
END
