
/*---------------------------------------------------------------------------------
PROPÓSITO           | Inserta un nuevo personal (empleado)
AUTOR               | Sibhell Dhaleska
FECHA DE CREACIÓN   | 2025-01-21
-----------------------------------------------------------------------------------
EJEMPLO:
    EXEC PA_Personal_Ins_Nuevo 1, 1, NULL, '2025-01-01', 2500.00, 'Nuevo empleado'
-----------------------------------------------------------------------------------*/
CREATE PROCEDURE PA_Personal_Ins_Nuevo(
    @nPersonaId         INT,
    @nCargoId           INT,
    @nPersonalLiderId   INT,
    @dFechaIngreso      DATE,
    @nSueldo            DECIMAL(10,2),
    @cObservaciones     VARCHAR(500)
)
AS
BEGIN
    SET NOCOUNT ON
    BEGIN TRY
        BEGIN TRAN
            IF EXISTS (SELECT 1 FROM Personal WHERE nPersonaId = @nPersonaId)
            BEGIN
                RAISERROR('Esta persona ya está registrada como personal', 16, 1)
                RETURN
            END

            INSERT INTO Personal (nPersonaId, nCargoId, nPersonalLiderId, dFechaIngreso, nSueldo, cObservaciones)
            VALUES (@nPersonaId, @nCargoId, @nPersonalLiderId, @dFechaIngreso, @nSueldo, @cObservaciones)

            SELECT SCOPE_IDENTITY() AS nPersonalId
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