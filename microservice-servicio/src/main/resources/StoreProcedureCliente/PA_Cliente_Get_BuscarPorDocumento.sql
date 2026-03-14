/*---------------------------------------------------------------------------------
PROPÓSITO          | Busca cliente por número de documento (sin tipo)
PARÁMETROS         | @cNumeroDocumento - Número de documento a buscar
AUTOR              | Sibhell Dhaleska
FECHA CREACIÓN     | 2025-01-23
---------------------------------------------------------------------------------*/
IF OBJECT_ID('PA_Cliente_Get_BuscarPorDocumento') IS NOT NULL
    DROP PROCEDURE PA_Cliente_Get_BuscarPorDocumento
GO

CREATE PROCEDURE PA_Cliente_Get_BuscarPorDocumento(
    @cNumeroDocumento VARCHAR(20)
)
AS
BEGIN
    SET NOCOUNT ON

    IF EXISTS (SELECT 1 FROM Cliente c
               INNER JOIN Persona p ON c.nPersonaId = p.nPersonaId
               WHERE p.cNumeroDocumento = @cNumeroDocumento AND c.bEstado = 1)
    BEGIN
        SELECT
            c.nClienteId,
            c.cClienteCod,
            p.cNumeroDocumento,
            COALESCE(c.cRazonSocial, p.cNombres + ' ' + p.cApellidoPaterno + ISNULL(' ' + p.cApellidoMaterno, '')) AS cNombreCompleto,
            p.cTelefono,
            p.cEmail,
            1 AS bEncontrado
        FROM Cliente c
        INNER JOIN Persona p ON c.nPersonaId = p.nPersonaId
        WHERE p.cNumeroDocumento = @cNumeroDocumento AND c.bEstado = 1
    END
    ELSE
    BEGIN
        SELECT
            NULL AS nClienteId,
            NULL AS cClienteCod,
            @cNumeroDocumento AS cNumeroDocumento,
            NULL AS cNombreCompleto,
            NULL AS cTelefono,
            NULL AS cEmail,
            0 AS bEncontrado
    END
END
GO