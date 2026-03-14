/*---------------------------------------------------------------------------------
PROPÓSITO           | Obtiene un menú por ID
AUTOR               | Sibhell Dhaleska
FECHA DE CREACIÓN   | 2025-01-21
-----------------------------------------------------------------------------------
EJEMPLO:
    EXEC PA_Menu_Get_PorId 1
-----------------------------------------------------------------------------------*/
CREATE PROCEDURE PA_Menu_Get_PorId(
    @nMenuId INT
)
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
    WHERE m.nMenuId = @nMenuId
END