/*---------------------------------------------------------------------------------
PROPÓSITO           | Elimina (lógico) una asignación de menú a cargo
AUTOR               | Sibhell Dhaleska
FECHA DE CREACIÓN   | 2025-01-21
-----------------------------------------------------------------------------------
EJEMPLO:
    EXEC PA_CargoMenu_Del_Eliminar 1
-----------------------------------------------------------------------------------*/
CREATE PROCEDURE PA_CargoMenu_Del_Eliminar(
    @nCargoMenuId INT
)
AS
BEGIN
    SET NOCOUNT ON
    BEGIN TRY
        BEGIN TRAN
            UPDATE CargoMenu SET bEstado = 0 WHERE nCargoMenuId = @nCargoMenuId

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
