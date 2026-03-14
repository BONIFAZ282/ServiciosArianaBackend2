package com.serviciosariana.app.servicio.Services;

import com.serviciosariana.app.servicio.Model.OrdenServicioPersonal;
import com.serviciosariana.app.servicio.Model.dto.PersonalDisponibleDTO;
import java.util.List;

public interface OrdenServicioPersonalService {

    Integer asignar(Integer nOrdenServicioId, Integer nPersonalId, String cObservaciones);

    void desasignar(Integer nOrdenServicioId, Integer nPersonalId);

    List<OrdenServicioPersonal> listarPorOrden(Integer nOrdenServicioId);

    List<PersonalDisponibleDTO> listarDisponibles(Integer nOrdenServicioId);
}