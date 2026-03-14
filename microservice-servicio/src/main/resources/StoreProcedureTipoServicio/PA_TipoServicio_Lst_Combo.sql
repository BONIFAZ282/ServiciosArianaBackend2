IF OBJECT_ID('PA_TipoServicio_Lst_Combo') IS NOT NULL
    DROP PROCEDURE PA_TipoServicio_Lst_Combo
GO

CREATE PROCEDURE PA_TipoServicio_Lst_Combo
AS
BEGIN
    SET NOCOUNT ON
    SELECT
        nTipoServicioId,
        cNombre,
        nPrecioBase
    FROM TipoServicio
    WHERE bEstado = 1
    ORDER BY cNombre
END
GO