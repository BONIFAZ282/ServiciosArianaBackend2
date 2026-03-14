/*---------------------------------------------------------------------------------
PROPÓSITO           | Obtiene un cargo por ID
AUTOR               | Sibhell Dhaleska
FECHA DE CREACIÓN   | 2025-01-21
-----------------------------------------------------------------------------------
EJEMPLO:
    EXEC PA_Cargo_Get_PorId 1
-----------------------------------------------------------------------------------*/
CREATE PROCEDURE PA_Cargo_Get_PorId(
    @nCargoId   INT
)
AS
BEGIN
    SET NOCOUNT ON
    SELECT
        nCargoId,
        cCargoCod,
        cNombre,
        cDescripcion,
        dFechaCreacion,
        bEstado
    FROM Cargo
    WHERE nCargoId = @nCargoId
END
