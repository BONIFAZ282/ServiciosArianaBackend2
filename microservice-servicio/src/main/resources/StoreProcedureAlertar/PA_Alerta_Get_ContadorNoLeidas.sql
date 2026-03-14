/*---------------------------------------------------------------------------------
PROPÓSITO          | Cuenta alertas no leídas
---------------------------------------------------------------------------------*/
IF OBJECT_ID('PA_Alerta_Get_ContadorNoLeidas') IS NOT NULL
    DROP PROCEDURE PA_Alerta_Get_ContadorNoLeidas
GO

CREATE PROCEDURE PA_Alerta_Get_ContadorNoLeidas(
    @nPersonalId INT = NULL
)
AS
BEGIN
    SET NOCOUNT ON
    SELECT
        COUNT(*) AS nTotalNoLeidas,
        SUM(CASE WHEN ta.cTipoAlertaCod = 'POR_VENCER' THEN 1 ELSE 0 END) AS nPorVencer,
        SUM(CASE WHEN ta.cTipoAlertaCod = 'VENCIDO' THEN 1 ELSE 0 END) AS nVencidas
    FROM Alerta a
    INNER JOIN TipoAlerta ta ON a.nTipoAlertaId = ta.nTipoAlertaId
    INNER JOIN OrdenServicio os ON a.nOrdenServicioId = os.nOrdenServicioId
    WHERE a.bEstado = 1 AND a.bLeida = 0
    AND (@nPersonalId IS NULL OR os.nPersonalLiderId = @nPersonalId)
END