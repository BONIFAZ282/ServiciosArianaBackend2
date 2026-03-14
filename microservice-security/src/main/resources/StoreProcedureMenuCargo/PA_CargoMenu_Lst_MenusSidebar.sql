/*---------------------------------------------------------------------------------
PROPÓSITO           | Lista menús para el sidebar (solo los que puede ver)
AUTOR               | Sibhell Dhaleska
FECHA DE CREACIÓN   | 2025-01-21
-----------------------------------------------------------------------------------
EJEMPLO:
    EXEC PA_CargoMenu_Lst_MenusPrincipal 1
-----------------------------------------------------------------------------------*/
CREATE PROCEDURE PA_CargoMenu_Lst_MenusPrincipal(
    @nCargoId INT
)
AS
BEGIN
    SET NOCOUNT ON
    SELECT
        m.nMenuId,
        m.cMenuCod,
        m.cNombre,
        m.cRuta,
        m.cIcono,
        m.nMenuPadreId,
        m.nOrden,
        cm.bVer,
        cm.bCrear,
        cm.bEditar,
        cm.bEliminar
    FROM CargoMenu cm
    INNER JOIN Menu m ON cm.nMenuId = m.nMenuId
    WHERE cm.nCargoId = @nCargoId AND cm.bEstado = 1 AND m.bEstado = 1 AND cm.bVer = 1 AND m.nMenuPadreId IS NULL
    ORDER BY m.nMenuPadreId, m.nOrden, m.cNombre
END