/*---------------------------------------------------------------------------------
PROPÓSITO           | Incrementa intentos fallidos y bloquea si es necesario
AUTOR               | Sibhell Dhaleska
FECHA DE CREACIÓN   | 2025-01-21
-----------------------------------------------------------------------------------
EJEMPLO:
    EXEC PA_Usuario_Upd_IntentoFallido 'jperez'
-----------------------------------------------------------------------------------*/
CREATE PROCEDURE PA_Usuario_Upd_IntentoFallido(
    @cUsuario VARCHAR(50)
)
AS
BEGIN
    SET NOCOUNT ON
    DECLARE @nIntentos INT
    DECLARE @nMaxIntentos INT = 3
    DECLARE @nMinutosBloqueo INT = 15

    SELECT @nIntentos = ISNULL(nIntentosFallidos, 0) + 1
    FROM Usuario
    WHERE cUsuario = @cUsuario

    IF @nIntentos >= @nMaxIntentos
    BEGIN
        UPDATE Usuario SET
            nIntentosFallidos = @nIntentos,
            dFechaBloqueo = DATEADD(MINUTE, @nMinutosBloqueo, GETDATE())
        WHERE cUsuario = @cUsuario

        SELECT 1 AS bBloqueado, @nMinutosBloqueo AS nMinutosBloqueo, 0 AS nIntentosRestantes
    END
    ELSE
    BEGIN
        UPDATE Usuario SET
            nIntentosFallidos = @nIntentos
        WHERE cUsuario = @cUsuario

        SELECT 0 AS bBloqueado, 0 AS nMinutosBloqueo, (@nMaxIntentos - @nIntentos) AS nIntentosRestantes
    END
END
