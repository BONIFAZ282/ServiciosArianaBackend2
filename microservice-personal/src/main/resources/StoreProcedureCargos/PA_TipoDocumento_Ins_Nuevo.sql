/*---------------------------------------------------------------------------------
PROPÓSITO           | Inserta un nuevo cargo
AUTOR               | Sibhell Dhaleska
FECHA DE CREACIÓN   | 2025-01-21
-----------------------------------------------------------------------------------
EJEMPLO:
    EXEC PA_Cargo_Ins_Nuevo 'AD001', 'Administrador', 'Acceso total al sistema'
-----------------------------------------------------------------------------------*/
CREATE PROCEDURE PA_Cargo_Ins_Nuevo(
    @cCargoCod      VARCHAR(20),
    @cNombre        VARCHAR(100),
    @cDescripcion   VARCHAR(250)
)
AS
BEGIN
    SET NOCOUNT ON
    BEGIN TRY
        BEGIN TRAN
            INSERT INTO Cargo (cCargoCod, cNombre, cDescripcion)
            VALUES (@cCargoCod, @cNombre, @cDescripcion)

            SELECT SCOPE_IDENTITY() AS nCargoId
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