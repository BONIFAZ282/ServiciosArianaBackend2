/*---------------------------------------------------------------------------------
PROPÓSITO           | Lista todos los menús activos
AUTOR               | Sibhell Dhaleska
FECHA DE CREACIÓN   | 2025-01-21
-----------------------------------------------------------------------------------
EJEMPLO:
    EXEC PA_Menu_Lst_Todos
-----------------------------------------------------------------------------------*/
CREATE PROCEDURE PA_Menu_Lst_Todos
AS
BEGIN
    SET NOCOUNT ON
    SELECT
        m.nMenuId,
        m.cMenuCod,
        m.cNombre,
        m.cDescripcion,
        m.cRuta,
        m.cIcono,
        m.nMenuPadreId,
        mp.cNombre AS cMenuPadreNombre,
        m.nOrden,
        m.dFechaCreacion,
        m.bEstado
    FROM Menu m
    LEFT JOIN Menu mp ON m.nMenuPadreId = mp.nMenuId
    WHERE m.bEstado = 1
    ORDER BY m.nOrden, m.cNombre
END