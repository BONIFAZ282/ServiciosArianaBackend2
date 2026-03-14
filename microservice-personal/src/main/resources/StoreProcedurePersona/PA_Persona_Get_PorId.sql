/*---------------------------------------------------------------------------------
PROPÓSITO           | Obtiene una persona por ID
AUTOR               | Sibhell Dhaleska
FECHA DE CREACIÓN   | 2025-01-21
-----------------------------------------------------------------------------------
EJEMPLO:
    EXEC PA_Persona_Get_PorId 1
-----------------------------------------------------------------------------------*/
CREATE PROCEDURE PA_Persona_Get_PorId(
    @nPersonaId INT
)
AS
BEGIN
    SET NOCOUNT ON
    SELECT
        p.nPersonaId,
        p.nTipoDocumentoId,
        td.cTipoDocCod,
        td.cNombre AS cTipoDocNombre,
        p.cNumeroDocumento,
        p.cNombres,
        p.cApellidoPaterno,
        p.cApellidoMaterno,
        p.cSexo,
        p.dFechaNacimiento,
        p.cTelefono,
        p.cEmail,
        p.cDireccion,
        p.dFechaCreacion,
        p.bEstado
    FROM Persona p
    INNER JOIN TipoDocumento td ON p.nTipoDocumentoId = td.nTipoDocumentoId
    WHERE p.nPersonaId = @nPersonaId
END