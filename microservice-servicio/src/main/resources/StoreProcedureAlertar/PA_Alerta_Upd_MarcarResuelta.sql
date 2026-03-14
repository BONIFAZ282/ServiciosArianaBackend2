/*---------------------------------------------------------------------------------
PROPÓSITO          | Marca alerta como resuelta (ya no aparece en listas)
---------------------------------------------------------------------------------*/
IF OBJECT_ID('PA_Alerta_Upd_MarcarResuelta') IS NOT NULL
    DROP PROCEDURE PA_Alerta_Upd_MarcarResuelta
GO

CREATE PROCEDURE PA_Alerta_Upd_MarcarResuelta(
    @nAlertaId INT,
    @nUsuarioId INT
)
AS
BEGIN
    SET NOCOUNT ON
    BEGIN TRY
        IF NOT EXISTS (SELECT 1 FROM Alerta WHERE nAlertaId = @nAlertaId AND bEstado = 1)
        BEGIN
            RAISERROR('La alerta no existe o ya fue resuelta', 16, 1)
            RETURN
        END

        -- Marcar como leída (si no lo estaba) y desactivar
        UPDATE Alerta SET
            bLeida = 1,
            dFechaLectura = CASE WHEN bLeida = 0 THEN GETDATE() ELSE dFechaLectura END,
            nUsuarioLecturaId = CASE WHEN bLeida = 0 THEN @nUsuarioId ELSE nUsuarioLecturaId END,
            bEstado = 0  -- Ya no aparecerá en listas
        WHERE nAlertaId = @nAlertaId

        SELECT @nAlertaId AS nAlertaId
    END TRY
    BEGIN CATCH
        DECLARE @ErrorMessage NVARCHAR(4000) = ERROR_MESSAGE()
        RAISERROR(@ErrorMessage, 16, 1)
    END CATCH
END
GO