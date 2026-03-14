/*---------------------------------------------------------------------------------
PROPÓSITO           | Actualiza un personal existente
AUTOR               | Sibhell Dhaleska
FECHA DE CREACIÓN   | 2025-01-21
-----------------------------------------------------------------------------------
EJEMPLO:
    EXEC PA_Personal_Upd_Actualizar 1, 1, NULL, '2025-01-01', NULL, 2500.00, 'Actualizado', 1
-----------------------------------------------------------------------------------*/
CREATE PROCEDURE PA_Personal_Upd_Actualizar(
    @nPersonalId        INT,
    @nCargoId           INT,
    @nPersonalLiderId   INT,
    @dFechaIngreso      DATE,
    @dFechaCese         DATE,
    @nSueldo            DECIMAL(10,2),
    @cObservaciones     VARCHAR(500),
    @bEstado            BIT
)
AS
BEGIN
    SET NOCOUNT ON
    BEGIN TRY
        BEGIN TRAN
            UPDATE Personal SET
                nCargoId = @nCargoId,
                nPersonalLiderId = @nPersonalLiderId,
                dFechaIngreso = @dFechaIngreso,
                dFechaCese = @dFechaCese,
                nSueldo = @nSueldo,
                cObservaciones = @cObservaciones,
                bEstado = @bEstado
            WHERE nPersonalId = @nPersonalId

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