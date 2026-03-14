
/*---------------------------------------------------------------------------------
PROPÓSITO           | Lista todos los tipos de documento activos
AUTOR               | Sibhell Dhaleska
FECHA DE CREACIÓN   | 2025-01-21
-----------------------------------------------------------------------------------
EJEMPLO:
    EXEC PA_TipoDocumento_Lst_Todos
-----------------------------------------------------------------------------------*/
CREATE PROCEDURE PA_TipoDocumento_Lst_Todos
AS
BEGIN
    SET NOCOUNT ON
    SELECT
        nTipoDocumentoId,
        cTipoDocCod,
        cNombre,
        cDescripcion,
        nLongitud,
        bEstado
    FROM TipoDocumento
    WHERE bEstado = 1
    ORDER BY cNombre
END