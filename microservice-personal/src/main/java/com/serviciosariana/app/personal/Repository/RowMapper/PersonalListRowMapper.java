package com.serviciosariana.app.personal.Repository.RowMapper;

import com.serviciosariana.app.personal.Model.dto.PersonalListDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonalListRowMapper implements RowMapper<PersonalListDTO> {
    @Override
    public PersonalListDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return PersonalListDTO.builder()
                .nPersonalId(rs.getInt("nPersonalId"))
                .nPersonaId(rs.getInt("nPersonaId"))
                .nTipoDocumentoId(rs.getInt("nTipoDocumentoId"))
                .cTipoDocNombre(rs.getString("cTipoDocNombre"))
                .cNumeroDocumento(rs.getString("cNumeroDocumento"))
                .cNombres(rs.getString("cNombres"))
                .cApellidoPaterno(rs.getString("cApellidoPaterno"))
                .cApellidoMaterno(rs.getString("cApellidoMaterno"))
                .cNombreCompleto(rs.getString("cNombreCompleto"))
                .dFechaNacimiento(toLocalDate(rs.getDate("dFechaNacimiento")))
                .cTelefono(rs.getString("cTelefono"))
                .cEmail(rs.getString("cEmail"))
                .cDireccion(rs.getString("cDireccion"))
                .nCargoId(rs.getInt("nCargoId"))
                .cCargoCod(rs.getString("cCargoCod"))
                .cCargoNombre(rs.getString("cCargoNombre"))
                .nPersonalLiderId(rs.getObject("nPersonalLiderId") != null ? rs.getInt("nPersonalLiderId") : null)
                .cLiderNombre(rs.getString("cLiderNombre"))
                .dFechaIngreso(toLocalDate(rs.getDate("dFechaIngreso")))
                .nSueldo(rs.getBigDecimal("nSueldo"))
                .bEstado(rs.getBoolean("bEstado"))
                .nUsuarioId(rs.getInt("nUsuarioId"))
                .cUsuario(rs.getString("cUsuario"))
                .bTieneUsuario(rs.getBoolean("bTieneUsuario"))
                .build();
    }
    private java.time.LocalDate toLocalDate(Date date) {
        return date != null ? date.toLocalDate() : null;
    }
}