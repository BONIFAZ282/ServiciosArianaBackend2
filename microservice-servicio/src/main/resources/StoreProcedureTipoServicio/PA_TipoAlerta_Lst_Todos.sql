CREATE PROCEDURE PA_TipoAlerta_Lst_Todos
AS
BEGIN
    SET NOCOUNT ON
    SELECT nTipoAlertaId, cTipoAlertaCod, cNombre, cDescripcion, cColor
    FROM TipoAlerta
    WHERE bEstado = 1
END