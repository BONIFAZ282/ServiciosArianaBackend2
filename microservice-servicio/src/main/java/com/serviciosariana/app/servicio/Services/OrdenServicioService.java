package com.serviciosariana.app.servicio.Services;

import com.serviciosariana.app.servicio.Model.OrdenServicio;
import com.serviciosariana.app.servicio.Model.OrdenServicioHistorial;
import com.serviciosariana.app.servicio.Model.dto.OrdenServicioCreatedDTO;
import com.serviciosariana.app.servicio.Model.dto.OrdenServicioRequest;
import com.serviciosariana.app.servicio.Model.dto.EquipoLiderDTO;
import com.serviciosariana.app.servicio.Model.dto.OrdenResumenLiderDTO;

import java.util.List;

public interface OrdenServicioService {

    OrdenServicioCreatedDTO crear(OrdenServicioRequest request);

    Integer actualizar(Integer nOrdenServicioId, OrdenServicioRequest request);

    void cambiarEstado(Integer nOrdenServicioId, String cEstadoOrdenCodNuevo, String cComentario, Integer nUsuarioId);

    void eliminar(Integer nOrdenServicioId);

    OrdenServicio obtenerPorId(Integer nOrdenServicioId);

    List<OrdenServicio> listarTodos();

    List<OrdenServicioHistorial> listarHistorial(Integer nOrdenServicioId);

    List<EquipoLiderDTO> listarEquipoPorLider(Integer nPersonalLiderId);
    List<OrdenResumenLiderDTO> listarResumenPorLider(Integer nPersonalLiderId);

}