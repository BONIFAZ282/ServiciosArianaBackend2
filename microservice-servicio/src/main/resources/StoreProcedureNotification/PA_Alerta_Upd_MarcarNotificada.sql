/*---------------------------------------------------------------------------------
PROPÓSITO          | Marca alerta como notificada por email
---------------------------------------------------------------------------------*/
IF OBJECT_ID('PA_Alerta_Upd_MarcarNotificada') IS NOT NULL
    DROP PROCEDURE PA_Alerta_Upd_MarcarNotificada
GO

CREATE PROCEDURE PA_Alerta_Upd_MarcarNotificada(
    @nAlertaId INT
)
AS
BEGIN
    SET NOCOUNT ON
    UPDATE Alerta SET
        bNotificadoEmail = 1,
        dFechaNotificacion = GETDATE()
    WHERE nAlertaId = @nAlertaId
END