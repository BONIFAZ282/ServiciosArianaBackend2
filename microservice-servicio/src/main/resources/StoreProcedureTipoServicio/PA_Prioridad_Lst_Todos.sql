CREATE PROCEDURE PA_Prioridad_Lst_Todos
AS
BEGIN
    SET NOCOUNT ON
    SELECT nPrioridadId, cPrioridadCod, cNombre, nDiasAlerta, cColor, nOrden
    FROM Prioridad
    WHERE bEstado = 1
    ORDER BY nOrden
END