package com.serviciosariana.app.servicio.Repository;

import com.serviciosariana.app.servicio.Model.ActividadEvidencia;
import java.util.List;
import java.util.Optional;

public interface ActividadEvidenciaRepository {

    Integer insertar(Integer nActividadId, String cNombreArchivo, String cRutaArchivo,
                     String cTipoArchivo, Integer nTamano);

    void eliminar(Integer nActividadEvidenciaId);

    List<ActividadEvidencia> listarPorActividad(Integer nActividadId);

    Optional<ActividadEvidencia> obtenerPorId(Integer nActividadEvidenciaId);
}