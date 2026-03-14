package com.serviciosariana.app.servicio.Repository;

import com.serviciosariana.app.servicio.Model.OrdenServicio;
import com.serviciosariana.app.servicio.Model.OrdenServicioHistorial;
import com.serviciosariana.app.servicio.Model.dto.EquipoLiderDTO;
import com.serviciosariana.app.servicio.Model.dto.OrdenResumenLiderDTO;
import com.serviciosariana.app.servicio.Model.dto.OrdenServicioCreatedDTO;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface OrdenServicioRepository {

    OrdenServicioCreatedDTO insertar(Integer nClienteId, Integer nTipoServicioId, Integer nPrioridadId,
                                     String cTitulo, String cDescripcion, LocalDate dFechaInicio,
                                     LocalDate dFechaFin, Integer nPersonalLiderId, String cDireccionServicio,
                                     BigDecimal nCostoEstimado, String cObservaciones, Integer nUsuarioCreacionId);

    Integer actualizar(Integer nOrdenServicioId, Integer nClienteId, Integer nTipoServicioId,
                       Integer nPrioridadId, String cTitulo, String cDescripcion, LocalDate dFechaInicio,
                       LocalDate dFechaFin, Integer nPersonalLiderId, String cDireccionServicio,
                       BigDecimal nCostoEstimado, BigDecimal nCostoReal, String cObservaciones);

    void cambiarEstado(Integer nOrdenServicioId, String cEstadoOrdenCodNuevo, String cComentario, Integer nUsuarioId);

    void eliminar(Integer nOrdenServicioId);

    Optional<OrdenServicio> obtenerPorId(Integer nOrdenServicioId);

    List<OrdenServicio> listarTodos();

    List<OrdenServicioHistorial> listarHistorial(Integer nOrdenServicioId);
    List<EquipoLiderDTO> listarEquipoPorLider(Integer nPersonalLiderId);
    List<OrdenResumenLiderDTO> listarResumenPorLider(Integer nPersonalLiderId);
}