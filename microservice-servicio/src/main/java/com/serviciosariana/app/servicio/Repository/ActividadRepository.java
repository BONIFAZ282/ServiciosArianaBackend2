package com.serviciosariana.app.servicio.Repository;

import com.serviciosariana.app.servicio.Model.Actividad;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ActividadRepository {

    Integer insertar(Integer nOrdenServicioId, Integer nPersonalId, String cTitulo,
                     String cDescripcion, LocalDate dFechaActividad);

    Integer actualizar(Integer nActividadId, String cTitulo, String cDescripcion, LocalDate dFechaActividad);

    void eliminar(Integer nActividadId);

    Optional<Actividad> obtenerPorId(Integer nActividadId);

    List<Actividad> listarPorOrden(Integer nOrdenServicioId);

    List<Actividad> listarPorPersonal(Integer nPersonalId);
}