
CREATE PROCEDURE PA_OrdenServicio_Ins_Nuevo(
    @nClienteId         INT,
    @nTipoServicioId    INT,
    @nPrioridadId       INT,
    @cTitulo            VARCHAR(200),
    @cDescripcion       VARCHAR(500),
    @dFechaInicio       DATE,
    @dFechaFin          DATE,
    @nPersonalLiderId   INT,
    @cDireccionServicio VARCHAR(300),
    @nCostoEstimado     DECIMAL(10,2),
    @cObservaciones     VARCHAR(500),
    @nUsuarioCreacionId INT
)
AS
BEGIN
    SET NOCOUNT ON
    BEGIN TRY
        BEGIN TRAN
            IF NOT EXISTS (SELECT 1 FROM Cliente WHERE nClienteId = @nClienteId AND bEstado = 1)
            BEGIN
                RAISERROR('El cliente no existe o está inactivo', 16, 1)
                RETURN
            END

            IF NOT EXISTS (SELECT 1 FROM TipoServicio WHERE nTipoServicioId = @nTipoServicioId AND bEstado = 1)
            BEGIN
                RAISERROR('El tipo de servicio no existe o está inactivo', 16, 1)
                RETURN
            END

            IF @dFechaFin < @dFechaInicio
            BEGIN
                RAISERROR('La fecha fin no puede ser menor a la fecha inicio', 16, 1)
                RETURN
            END

            -- Generar código: OS-2025-0001
            DECLARE @cOrdenServicioCod VARCHAR(20)
            DECLARE @nAnio INT = YEAR(GETDATE())
            DECLARE @nCorrelativo INT

            SELECT @nCorrelativo = ISNULL(MAX(CAST(SUBSTRING(cOrdenServicioCod, 9, 4) AS INT)), 0) + 1
            FROM OrdenServicio
            WHERE cOrdenServicioCod LIKE 'OS-' + CAST(@nAnio AS VARCHAR) + '-%'

            SET @cOrdenServicioCod = 'OS-' + CAST(@nAnio AS VARCHAR) + '-' + RIGHT('0000' + CAST(@nCorrelativo AS VARCHAR), 4)

            -- Estado inicial: PENDIENTE
            DECLARE @nEstadoOrdenId INT
            SELECT @nEstadoOrdenId = nEstadoOrdenId FROM EstadoOrden WHERE cEstadoOrdenCod = 'PENDIENTE'

            INSERT INTO OrdenServicio (
                cOrdenServicioCod, nClienteId, nTipoServicioId, nPrioridadId, nEstadoOrdenId,
                cTitulo, cDescripcion, dFechaInicio, dFechaFin, nPersonalLiderId,
                cDireccionServicio, nCostoEstimado, cObservaciones, nUsuarioCreacionId
            )
            VALUES (
                @cOrdenServicioCod, @nClienteId, @nTipoServicioId, @nPrioridadId, @nEstadoOrdenId,
                @cTitulo, @cDescripcion, @dFechaInicio, @dFechaFin, @nPersonalLiderId,
                @cDireccionServicio, @nCostoEstimado, @cObservaciones, @nUsuarioCreacionId
            )

            DECLARE @nOrdenServicioId INT = SCOPE_IDENTITY()

            -- Registrar historial
            INSERT INTO OrdenServicioHistorial (nOrdenServicioId, nEstadoOrdenAnteriorId, nEstadoOrdenNuevoId, cComentario, nUsuarioId)
            VALUES (@nOrdenServicioId, NULL, @nEstadoOrdenId, 'Orden creada', @nUsuarioCreacionId)

            SELECT @nOrdenServicioId AS nOrdenServicioId, @cOrdenServicioCod AS cOrdenServicioCod
        COMMIT TRAN
    END TRY
    BEGIN CATCH
        IF @@TRANCOUNT > 0 ROLLBACK TRAN
        DECLARE @ErrorMessage NVARCHAR(4000) = ERROR_MESSAGE()
        RAISERROR(@ErrorMessage, 16, 1)
    END CATCH
END