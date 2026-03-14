/*---------------------------------------------------------------------------------
PROPÓSITO          | Marca alerta como leída
---------------------------------------------------------------------------------*/
IF OBJECT_ID('PA_Alerta_Upd_MarcarLeida') IS NOT NULL
    DROP PROCEDURE PA_Alerta_Upd_MarcarLeida
GO

CREATE PROCEDURE PA_Alerta_Upd_MarcarLeida(
    @nAlertaId INT,
    @nUsuarioId INT
)
AS
BEGIN
    SET NOCOUNT ON
    BEGIN TRY
        IF NOT EXISTS (SELECT 1 FROM Alerta WHERE nAlertaId = @nAlertaId AND bEstado = 1)
        BEGIN
            RAISERROR('La alerta no existe', 16, 1)
            RETURN
        END

        UPDATE Alerta SET
            bLeida = 1,
            dFechaLectura = GETDATE(),
            nUsuarioLecturaId = @nUsuarioId
        WHERE nAlertaId = @nAlertaId

        SELECT @nAlertaId AS nAlertaId
    END TRY
    BEGIN CATCH
        DECLARE @ErrorMessage NVARCHAR(4000) = ERROR_MESSAGE()
        RAISERROR(@ErrorMessage, 16, 1)
    END CATCH
END