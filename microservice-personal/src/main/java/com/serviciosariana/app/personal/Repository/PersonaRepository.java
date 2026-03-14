package com.serviciosariana.app.personal.Repository;

import com.serviciosariana.app.personal.Model.Persona;
import java.time.LocalDate;
import java.util.Optional;

public interface PersonaRepository {
    Optional<Persona> obtenerPorId(Integer nPersonaId);
    Optional<Persona> obtenerPorDocumento(String cNumeroDocumento);
    Integer insertar(Integer nTipoDocumentoId, String cNumeroDocumento, String cNombres, String cApellidoPaterno, String cApellidoMaterno, String cSexo, LocalDate dFechaNacimiento, String cTelefono, String cEmail, String cDireccion);
    void actualizar(Integer nPersonaId, Integer nTipoDocumentoId, String cNumeroDocumento, String cNombres, String cApellidoPaterno, String cApellidoMaterno, String cSexo, LocalDate dFechaNacimiento, String cTelefono, String cEmail, String cDireccion, Boolean bEstado);

}