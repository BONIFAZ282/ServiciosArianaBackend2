
/*---------------------------------------------------------------------------------
PROPÓSITO           | Lista todos los cargos activos
AUTOR               | Sibhell Dhaleska
FECHA DE CREACIÓN   | 2025-01-21
-----------------------------------------------------------------------------------
EJEMPLO:
    EXEC PA_Cargo_Lst_Todos
-----------------------------------------------------------------------------------*/
CREATE PROCEDURE PA_Cargo_Lst_Todos
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
    WHERE bEstado = 1
    ORDER BY cNombre
END