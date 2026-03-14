package com.serviciosariana.app.servicio.Services;

import com.serviciosariana.app.servicio.Model.Actividad;
import com.serviciosariana.app.servicio.Model.dto.ActividadRequest;
import com.serviciosariana.app.servicio.Repository.ActividadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActividadServiceImpl implements ActividadService {

    @Autowired
    private ActividadRepository actividadRepository;

    @Override
    public Integer crear(ActividadRequest request) {
        return actividadRepository.insertar(
                request.getNOrdenServicioId(),
                request.getNPersonalId(),
                request.getCTitulo(),
                request.getCDescripcion(),
                request.getDFechaActividad()
        );
    }

    @Override
    public Integer actualizar(Integer nActividadId, ActividadRequest request) {
        return actividadRepository.actualizar(
                nActividadId,
                request.getCTitulo(),
                request.getCDescripcion(),
                request.getDFechaActividad()
        );
    }

    @Override
    public void eliminar(Integer nActividadId) {
        actividadRepository.eliminar(nActividadId);
    }

    @Override
    public Actividad obtenerPorId(Integer nActividadId) {
        return actividadRepository.obtenerPorId(nActividadId)
                .orElseThrow(() -> new RuntimeException("Actividad no encontrada"));
    }

    @Override
    public List<Actividad> listarPorOrden(Integer nOrdenServicioId) {
        return actividadRepository.listarPorOrden(nOrdenServicioId);
    }

    @Override
    public List<Actividad> listarPorPersonal(Integer nPersonalId) {
        return actividadRepository.listarPorPersonal(nPersonalId);
    }
}