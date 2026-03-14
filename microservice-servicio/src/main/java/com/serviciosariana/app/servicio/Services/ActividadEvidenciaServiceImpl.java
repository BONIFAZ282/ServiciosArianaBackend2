package com.serviciosariana.app.servicio.Services;

import com.serviciosariana.app.servicio.Model.ActividadEvidencia;
import com.serviciosariana.app.servicio.Model.dto.EvidenciaRequest;
import com.serviciosariana.app.servicio.Repository.ActividadEvidenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActividadEvidenciaServiceImpl implements ActividadEvidenciaService {

    @Autowired
    private ActividadEvidenciaRepository actividadEvidenciaRepository;

    @Override
    public Integer agregar(Integer nActividadId, EvidenciaRequest request) {
        return actividadEvidenciaRepository.insertar(
                nActividadId,
                request.getCNombreArchivo(),
                request.getCRutaArchivo(),
                request.getCTipoArchivo(),
                request.getNTamano()
        );
    }

    @Override
    public void eliminar(Integer nActividadEvidenciaId) {
        actividadEvidenciaRepository.eliminar(nActividadEvidenciaId);
    }

    @Override
    public List<ActividadEvidencia> listarPorActividad(Integer nActividadId) {
        return actividadEvidenciaRepository.listarPorActividad(nActividadId);
    }

    @Override
    public ActividadEvidencia obtenerPorId(Integer nActividadEvidenciaId) {
        return actividadEvidenciaRepository.obtenerPorId(nActividadEvidenciaId)
                .orElseThrow(() -> new RuntimeException("Evidencia no encontrada"));
    }
}