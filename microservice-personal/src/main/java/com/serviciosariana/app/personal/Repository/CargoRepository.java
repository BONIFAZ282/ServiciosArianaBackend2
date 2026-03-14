package com.serviciosariana.app.personal.Repository;

import com.serviciosariana.app.personal.Model.Cargo;
import java.util.List;
import java.util.Optional;

public interface CargoRepository {
    List<Cargo> listarTodos();
    Optional<Cargo> obtenerPorId(Integer nCargoId);
    Integer insertar(String cCargoCod, String cNombre, String cDescripcion);
    void actualizar(Integer nCargoId, String cCargoCod, String cNombre, String cDescripcion, Boolean bEstado);
    void eliminar(Integer nCargoId);
}