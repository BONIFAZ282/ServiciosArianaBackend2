package com.serviciosariana.app.servicio.Services;

import com.serviciosariana.app.servicio.Model.Actividad;
import com.serviciosariana.app.servicio.Model.dto.ActividadRequest;
import java.util.List;

public interface ActividadService {

    Integer crear(ActividadRequest request);

    Integer actualizar(Integer nActividadId, ActividadRequest request);

    void eliminar(Integer nActividadId);

    Actividad obtenerPorId(Integer nActividadId);

    List<Actividad> listarPorOrden(Integer nOrdenServicioId);

    List<Actividad> listarPorPersonal(Integer nPersonalId);
}