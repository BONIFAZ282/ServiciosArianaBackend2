package com.serviciosariana.app.personal.Repository;

import com.serviciosariana.app.personal.Model.Personal;
import com.serviciosariana.app.personal.Model.dto.LiderDTO;
import com.serviciosariana.app.personal.Model.dto.PersonalConLiderDTO;
import com.serviciosariana.app.personal.Model.dto.PersonalListDTO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PersonalRepository {
    List<PersonalListDTO> listarTodos();
    List<PersonalListDTO> listarPorCargo(Integer nCargoId);
    List<PersonalListDTO> listarPorLider(Integer nPersonalLiderId);
    List<LiderDTO> listarLideres();
    Optional<Personal> obtenerPorId(Integer nPersonalId);
    Integer insertar(Integer nPersonaId, Integer nCargoId, Integer nPersonalLiderId, LocalDate dFechaIngreso, BigDecimal nSueldo, String cObservaciones);
    void actualizar(Integer nPersonalId, Integer nCargoId, Integer nPersonalLiderId, LocalDate dFechaIngreso, LocalDate dFechaCese, BigDecimal nSueldo, String cObservaciones, Boolean bEstado);
    void eliminar(Integer nPersonalId);
    List<PersonalConLiderDTO> listarConLider();

}