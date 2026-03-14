/*---------------------------------------------------------------------------------
PROPÓSITO           | Lista menús padres (para combos)
AUTOR               | Sibhell Dhaleska
FECHA DE CREACIÓN   | 2025-01-21
-----------------------------------------------------------------------------------
EJEMPLO:
    EXEC PA_Menu_Lst_Padres
-----------------------------------------------------------------------------------*/
CREATE PROCEDURE PA_Menu_Lst_Padres
AS
BEGIN
    SET NOCOUNT ON
    SELECT
        nMenuId,
        cMenuCod,
        cNombre,
        cIcono,
        nOrden
    FROM Menu
    WHERE nMenuPadreId IS NULL AND bEstado = 1
    ORDER BY nOrden, cNombre
END