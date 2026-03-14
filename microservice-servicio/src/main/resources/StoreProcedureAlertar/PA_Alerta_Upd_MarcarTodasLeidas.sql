IF OBJECT_ID('PA_Alerta_Upd_MarcarTodasLeidas') IS NOT NULL
    DROP PROCEDURE PA_Alerta_Upd_MarcarTodasLeidas
GO

CREATE PROCEDURE PA_Alerta_Upd_MarcarTodasLeidas(
    @nPersonalId INT = NULL,
    @nUsuarioId INT
)
AS
BEGIN
    SET NOCOUNT ON

    UPDATE a SET
        bLeida = 1,
        dFechaLectura = GETDATE(),
        nUsuarioLecturaId = @nUsuarioId
    FROM Alerta a
    INNER JOIN OrdenServicio os ON a.nOrdenServicioId = os.nOrdenServicioId
    WHERE a.bEstado = 1 AND a.bLeida = 0
    AND (@nPersonalId IS NULL OR os.nPersonalLiderId = @nPersonalId)

    SELECT @@ROWCOUNT AS nAlertasMarcadas
END