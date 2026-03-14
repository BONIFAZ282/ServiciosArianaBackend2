package com.serviciosariana.app.servicio.Services;

import com.serviciosariana.app.servicio.Model.OrdenServicioPersonal;
import com.serviciosariana.app.servicio.Model.dto.PersonalDisponibleDTO;
import com.serviciosariana.app.servicio.Repository.OrdenServicioPersonalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdenServicioPersonalServiceImpl implements OrdenServicioPersonalService {

    @Autowired
    private OrdenServicioPersonalRepository ordenServicioPersonalRepository;

    @Override
    public Integer asignar(Integer nOrdenServicioId, Integer nPersonalId, String cObservaciones) {
        return ordenServicioPersonalRepository.asignar(nOrdenServicioId, nPersonalId, cObservaciones);
    }

    @Override
    public void desasignar(Integer nOrdenServicioId, Integer nPersonalId) {
        ordenServicioPersonalRepository.desasignar(nOrdenServicioId, nPersonalId);
    }

    @Override
    public List<OrdenServicioPersonal> listarPorOrden(Integer nOrdenServicioId) {
        return ordenServicioPersonalRepository.listarPorOrden(nOrdenServicioId);
    }

    @Override
    public List<PersonalDisponibleDTO> listarDisponibles(Integer nOrdenServicioId) {
        return ordenServicioPersonalRepository.listarDisponibles(nOrdenServicioId);
    }
}