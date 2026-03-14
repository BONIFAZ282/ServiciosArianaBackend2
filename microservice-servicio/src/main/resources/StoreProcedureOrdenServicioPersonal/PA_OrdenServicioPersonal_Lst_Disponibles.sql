CREATE PROCEDURE PA_OrdenServicioPersonal_Lst_Disponibles(
    @nOrdenServicioId INT
)
AS
BEGIN
    SET NOCOUNT ON
    SELECT
        pe.nPersonalId,
        p.cNombres + ' ' + p.cApellidoPaterno AS cPersonalNombre,
        c.cNombre AS cCargoNombre, p.cTelefono
    FROM Personal pe
    INNER JOIN Persona p ON pe.nPersonaId = p.nPersonaId
    INNER JOIN Cargo c ON pe.nCargoId = c.nCargoId
    WHERE pe.bEstado = 1
    AND pe.nPersonalId NOT IN (
        SELECT nPersonalId FROM OrdenServicioPersonal
        WHERE nOrdenServicioId = @nOrdenServicioId AND bActivo = 1
    )
    ORDER BY p.cApellidoPaterno, p.cNombres
END