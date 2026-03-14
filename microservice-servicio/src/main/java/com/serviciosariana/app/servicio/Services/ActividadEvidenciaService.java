package com.serviciosariana.app.servicio.Services;

import com.serviciosariana.app.servicio.Model.ActividadEvidencia;
import com.serviciosariana.app.servicio.Model.dto.EvidenciaRequest;
import java.util.List;

public interface ActividadEvidenciaService {

    Integer agregar(Integer nActividadId, EvidenciaRequest request);

    void eliminar(Integer nActividadEvidenciaId);

    List<ActividadEvidencia> listarPorActividad(Integer nActividadId);

    ActividadEvidencia obtenerPorId(Integer nActividadEvidenciaId);
}