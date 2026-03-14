package com.serviciosariana.app.personal.Repository;

import com.serviciosariana.app.personal.Model.Persona;
import com.serviciosariana.app.personal.Repository.RowMapper.PersonaRowMapper;
import com.serviciosariana.app.personal.Repository.StoredProcedure.StoredProcedurePersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonaRepositoryImpl implements PersonaRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Optional<Persona> obtenerPorId(Integer nPersonaId) {
        List<Persona> lista = jdbcTemplate.query(StoredProcedurePersona.GET_POR_ID, new Object[]{nPersonaId}, new PersonaRowMapper());
        return lista.stream().findFirst();
    }

    @Override
    public Optional<Persona> obtenerPorDocumento(String cNumeroDocumento) {
        List<Persona> lista = jdbcTemplate.query(StoredProcedurePersona.GET_POR_DOCUMENTO, new Object[]{cNumeroDocumento}, new PersonaRowMapper());
        return lista.stream().findFirst();
    }

    @Override
    public Integer insertar(Integer nTipoDocumentoId, String cNumeroDocumento, String cNombres, String cApellidoPaterno, String cApellidoMaterno, String cSexo, LocalDate dFechaNacimiento, String cTelefono, String cEmail, String cDireccion) {
        return jdbcTemplate.queryForObject(
                StoredProcedurePersona.INS_NUEVO,
                new Object[]{nTipoDocumentoId, cNumeroDocumento, cNombres, cApellidoPaterno, cApellidoMaterno, cSexo, dFechaNacimiento != null ? Date.valueOf(dFechaNacimiento) : null, cTelefono, cEmail, cDireccion},
                Integer.class
        );
    }

    @Override
    public void actualizar(Integer nPersonaId, Integer nTipoDocumentoId, String cNumeroDocumento, String cNombres, String cApellidoPaterno, String cApellidoMaterno, String cSexo, LocalDate dFechaNacimiento, String cTelefono, String cEmail, String cDireccion, Boolean bEstado) {
        jdbcTemplate.update(
                StoredProcedurePersona.UPD_ACTUALIZAR,
                nPersonaId, nTipoDocumentoId, cNumeroDocumento, cNombres, cApellidoPaterno, cApellidoMaterno, cSexo, dFechaNacimiento != null ? Date.valueOf(dFechaNacimiento) : null, cTelefono, cEmail, cDireccion, bEstado
        );
    }
}