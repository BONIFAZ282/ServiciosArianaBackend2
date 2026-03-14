/*---------------------------------------------------------------------------------
PROPÓSITO           | Actualiza un menú existente
AUTOR               | Sibhell Dhaleska
FECHA DE CREACIÓN   | 2025-01-21
-----------------------------------------------------------------------------------
EJEMPLO:
    EXEC PA_Menu_Upd_Actualizar 1, 'MNU001', 'Dashboard', 'Panel principal', '/dashboard', 'fa-home', NULL, 1, 1
-----------------------------------------------------------------------------------*/
CREATE PROCEDURE PA_Menu_Upd_Actualizar(
    @nMenuId        INT,
    @cMenuCod       VARCHAR(20),
    @cNombre        VARCHAR(100),
    @cDescripcion   VARCHAR(250),
    @cRuta          VARCHAR(200),
    @cIcono         VARCHAR(50),
    @nMenuPadreId   INT,
    @nOrden         INT,
    @bEstado        BIT
)
AS
BEGIN
    SET NOCOUNT ON
    BEGIN TRY
        BEGIN TRAN
            UPDATE Menu SET
                cMenuCod = @cMenuCod,
                cNombre = @cNombre,
                cDescripcion = @cDescripcion,
                cRuta = @cRuta,
                cIcono = @cIcono,
                nMenuPadreId = @nMenuPadreId,
                nOrden = @nOrden,
                bEstado = @bEstado
            WHERE nMenuId = @nMenuId

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