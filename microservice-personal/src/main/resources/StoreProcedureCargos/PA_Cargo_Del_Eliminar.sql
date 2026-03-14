/*---------------------------------------------------------------------------------
PROPÓSITO           | Elimina (lógico) un cargo
AUTOR               | Sibhell Dhaleska
FECHA DE CREACIÓN   | 2025-01-21
-----------------------------------------------------------------------------------
EJEMPLO:
    EXEC PA_Cargo_Del_Eliminar 1
-----------------------------------------------------------------------------------*/
CREATE PROCEDURE PA_Cargo_Del_Eliminar(
    @nCargoId   INT
)
AS
BEGIN
    SET NOCOUNT ON
    BEGIN TRY
        BEGIN TRAN
            UPDATE Cargo SET bEstado = 0 WHERE nCargoId = @nCargoId


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
