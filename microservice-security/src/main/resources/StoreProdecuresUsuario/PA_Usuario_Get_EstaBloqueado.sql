/*---------------------------------------------------------------------------------
PROPÓSITO           | Verifica si el usuario está bloqueado
AUTOR               | Sibhell Dhaleska
FECHA DE CREACIÓN   | 2025-01-21
-----------------------------------------------------------------------------------
EJEMPLO:
    EXEC PA_Usuario_Get_EstaBloqueado 'jperez'
-----------------------------------------------------------------------------------*/
CREATE PROCEDURE PA_Usuario_Get_EstaBloqueado(
    @cUsuario VARCHAR(50)
)
AS
BEGIN
    SET NOCOUNT ON
    DECLARE @dFechaBloqueo DATETIME
    DECLARE @bEstado BIT

    SELECT
        @dFechaBloqueo = dFechaBloqueo,
        @bEstado = bEstado
    FROM Usuario WITH(NOLOCK)
    WHERE cUsuario = @cUsuario

    IF @bEstado = 0
    BEGIN
        SELECT 1 AS bBloqueado, 'Usuario inactivo' AS cMensaje, NULL AS dFechaDesbloqueo
        RETURN
    END

    IF @dFechaBloqueo IS NOT NULL AND @dFechaBloqueo > GETDATE()
    BEGIN
        SELECT 1 AS bBloqueado, 'Cuenta bloqueada temporalmente' AS cMensaje, @dFechaBloqueo AS dFechaDesbloqueo
        RETURN
    END

    IF @dFechaBloqueo IS NOT NULL AND @dFechaBloqueo <= GETDATE()
    BEGIN
        UPDATE Usuario SET
            nIntentosFallidos = 0,
            dFechaBloqueo = NULL
        WHERE cUsuario = @cUsuario
    END

    SELECT 0 AS bBloqueado, NULL AS cMensaje, NULL AS dFechaDesbloqueo
END