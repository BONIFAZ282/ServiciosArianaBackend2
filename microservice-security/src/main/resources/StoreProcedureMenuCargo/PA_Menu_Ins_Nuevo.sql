/*---------------------------------------------------------------------------------
PROPÓSITO           | Inserta un nuevo menú
AUTOR               | Sibhell Dhaleska
FECHA DE CREACIÓN   | 2025-01-21
-----------------------------------------------------------------------------------
EJEMPLO:
    EXEC PA_Menu_Ins_Nuevo 'MNU001', 'Dashboard', 'Panel principal', '/dashboard', 'fa-home', NULL, 1
-----------------------------------------------------------------------------------*/
CREATE PROCEDURE PA_Menu_Ins_Nuevo(
    @cMenuCod       VARCHAR(20),
    @cNombre        VARCHAR(100),
    @cDescripcion   VARCHAR(250),
    @cRuta          VARCHAR(200),
    @cIcono         VARCHAR(50),
    @nMenuPadreId   INT,
    @nOrden         INT
)
AS
BEGIN
    SET NOCOUNT ON
    BEGIN TRY
        BEGIN TRAN
            INSERT INTO Menu (cMenuCod, cNombre, cDescripcion, cRuta, cIcono, nMenuPadreId, nOrden)
            VALUES (@cMenuCod, @cNombre, @cDescripcion, @cRuta, @cIcono, @nMenuPadreId, @nOrden)

            SELECT SCOPE_IDENTITY() AS nMenuId
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
