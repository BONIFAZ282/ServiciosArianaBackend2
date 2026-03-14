/*---------------------------------------------------------------------------------
PROPÓSITO           | Elimina todos los menús de un cargo
AUTOR               | Sibhell Dhaleska
FECHA DE CREACIÓN   | 2025-01-21
-----------------------------------------------------------------------------------
EJEMPLO:
    EXEC PA_CargoMenu_Del_TodosPorCargo 1
-----------------------------------------------------------------------------------*/
CREATE PROCEDURE PA_CargoMenu_Del_TodosPorCargo(
    @nCargoId INT
)
AS
BEGIN
    SET NOCOUNT ON
    BEGIN TRY
        BEGIN TRAN
            UPDATE CargoMenu SET bEstado = 0 WHERE nCargoId = @nCargoId

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