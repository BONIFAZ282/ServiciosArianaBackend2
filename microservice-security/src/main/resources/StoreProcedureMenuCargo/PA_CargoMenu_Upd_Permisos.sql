/*---------------------------------------------------------------------------------
PROPÓSITO           | Actualiza los permisos de un cargo sobre un menú
AUTOR               | Sibhell Dhaleska
FECHA DE CREACIÓN   | 2025-01-21
-----------------------------------------------------------------------------------
EJEMPLO:
    EXEC PA_CargoMenu_Upd_Permisos 1, 1, 1, 1, 1, 1
-----------------------------------------------------------------------------------*/
CREATE PROCEDURE PA_CargoMenu_Upd_Permisos(
    @nCargoMenuId   INT,
    @bVer           BIT,
    @bCrear         BIT,
    @bEditar        BIT,
    @bEliminar      BIT,
    @bEstado        BIT
)
AS
BEGIN
    SET NOCOUNT ON
    BEGIN TRY
        BEGIN TRAN
            UPDATE CargoMenu SET
                bVer = @bVer,
                bCrear = @bCrear,
                bEditar = @bEditar,
                bEliminar = @bEliminar,
                bEstado = @bEstado
            WHERE nCargoMenuId = @nCargoMenuId

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