/*---------------------------------------------------------------------------------
PROPÓSITO           | Lista los menús asignados a un cargo
AUTOR               | Sibhell Dhaleska
FECHA DE CREACIÓN   | 2025-01-21
-----------------------------------------------------------------------------------
EJEMPLO:
    EXEC PA_CargoMenu_Lst_PorCargo 1
-----------------------------------------------------------------------------------*/
CREATE PROCEDURE PA_CargoMenu_Lst_PorCargo(
    @nCargoId INT
)
AS
BEGIN
    SET NOCOUNT ON
    SELECT
        cm.nCargoMenuId,
        cm.nCargoId,
        cm.nMenuId,
        m.cMenuCod,
        m.cNombre AS cMenuNombre,
        m.cRuta,
        m.cIcono,
        m.nMenuPadreId,
        mp.cNombre AS cMenuPadreNombre,
        m.nOrden,
        cm.bVer,
        cm.bCrear,
        cm.bEditar,
        cm.bEliminar,
        cm.bEstado
    FROM CargoMenu cm
    INNER JOIN Menu m ON cm.nMenuId = m.nMenuId
    LEFT JOIN Menu mp ON m.nMenuPadreId = mp.nMenuId
    WHERE cm.nCargoId = @nCargoId AND cm.bEstado = 1 AND m.bEstado = 1
    ORDER BY m.nOrden, m.cNombre
END
