/*---------------------------------------------------------------------------------
PROPÓSITO           | Asigna un menú a un cargo con sus permisos
AUTOR               | Sibhell Dhaleska
FECHA DE CREACIÓN   | 2025-01-21
-----------------------------------------------------------------------------------
EJEMPLO:
    EXEC PA_CargoMenu_Ins_Asignar 1, 1, 1, 1, 1, 0
-----------------------------------------------------------------------------------*/
CREATE PROCEDURE PA_CargoMenu_Ins_Asignar(
    @nCargoId       INT,
    @nMenuId        INT,
    @bVer           BIT,
    @bCrear         BIT,
    @bEditar        BIT,
    @bEliminar      BIT
)
AS
BEGIN
    SET NOCOUNT ON
    BEGIN TRY
        BEGIN TRAN
            IF EXISTS (SELECT 1 FROM CargoMenu WHERE nCargoId = @nCargoId AND nMenuId = @nMenuId)
            BEGIN
                RAISERROR('El menú ya está asignado a este cargo', 16, 1)
                RETURN
            END

            INSERT INTO CargoMenu (nCargoId, nMenuId, bVer, bCrear, bEditar, bEliminar)
            VALUES (@nCargoId, @nMenuId, @bVer, @bCrear, @bEditar, @bEliminar)

            SELECT SCOPE_IDENTITY() AS nCargoMenuId
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