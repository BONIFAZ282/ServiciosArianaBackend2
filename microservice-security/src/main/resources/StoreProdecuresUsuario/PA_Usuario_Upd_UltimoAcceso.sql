/*---------------------------------------------------------------------------------
PROPÓSITO           | Actualiza el último acceso del usuario (login exitoso)
AUTOR               | Sibhell Dhaleska
FECHA DE CREACIÓN   | 2025-01-21
-----------------------------------------------------------------------------------
EJEMPLO:
    EXEC PA_Usuario_Upd_UltimoAcceso 1
-----------------------------------------------------------------------------------*/
CREATE PROCEDURE PA_Usuario_Upd_UltimoAcceso(
    @nUsuarioId INT
)
AS
BEGIN
    SET NOCOUNT ON
    UPDATE Usuario SET
        dUltimoAcceso = GETDATE(),
        nIntentosFallidos = 0,
        dFechaBloqueo = NULL
    WHERE nUsuarioId = @nUsuarioId
END
