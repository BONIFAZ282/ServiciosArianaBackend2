package com.serviciosariana.app.personal.Services;

import com.serviciosariana.app.personal.Model.Personal;
import com.serviciosariana.app.personal.Model.dto.LiderDTO;
import com.serviciosariana.app.personal.Model.dto.PersonaRequest;
import com.serviciosariana.app.personal.Model.dto.PersonalConLiderDTO;
import com.serviciosariana.app.personal.Model.dto.PersonalListDTO;
import com.serviciosariana.app.personal.Repository.PersonaRepository;
import com.serviciosariana.app.personal.Repository.PersonalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PersonalServiceImpl implements PersonalService {

    @Autowired
    private PersonalRepository personalRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public List<PersonalListDTO> listarTodos() {
        return personalRepository.listarTodos();
    }

    @Override
    public List<PersonalListDTO> listarPorCargo(Integer nCargoId) {
        return personalRepository.listarPorCargo(nCargoId);
    }

    @Override
    public List<PersonalListDTO> listarPorLider(Integer nPersonalLiderId) {
        return personalRepository.listarPorLider(nPersonalLiderId);
    }

    @Override
    public List<LiderDTO> listarLideres() {
        return personalRepository.listarLideres();
    }

    @Override
    public Optional<Personal> obtenerPorId(Integer nPersonalId) {
        return personalRepository.obtenerPorId(nPersonalId);
    }

    @Override
    @Transactional
    public Integer crear(PersonaRequest persona, Integer nCargoId, Integer nPersonalLiderId, LocalDate dFechaIngreso, BigDecimal nSueldo, String cObservaciones) {
        // 1. Crear Persona
        Integer nPersonaId = personaRepository.insertar(
                persona.getNTipoDocumentoId(),
                persona.getCNumeroDocumento(),
                persona.getCNombres(),
                persona.getCApellidoPaterno(),
                persona.getCApellidoMaterno(),
                persona.getCSexo(),
                persona.getDFechaNacimiento(),
                persona.getCTelefono(),
                persona.getCEmail(),
                persona.getCDireccion()
        );

        // 2. Crear Personal
        return personalRepository.insertar(nPersonaId, nCargoId, nPersonalLiderId, dFechaIngreso, nSueldo, cObservaciones);
    }

    @Override
    public void actualizar(Integer nPersonalId, Integer nCargoId, Integer nPersonalLiderId, LocalDate dFechaIngreso, LocalDate dFechaCese, BigDecimal nSueldo, String cObservaciones, Boolean bEstado) {
        personalRepository.actualizar(nPersonalId, nCargoId, nPersonalLiderId, dFechaIngreso, dFechaCese, nSueldo, cObservaciones, bEstado);
    }

    @Override
    public void eliminar(Integer nPersonalId) {
        personalRepository.eliminar(nPersonalId);
    }

    @Override
    public List<PersonalConLiderDTO> listarConLider() {
        return personalRepository.listarConLider();
    }
}