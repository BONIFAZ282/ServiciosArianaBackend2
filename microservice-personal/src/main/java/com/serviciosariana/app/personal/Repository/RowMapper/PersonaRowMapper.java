package com.serviciosariana.app.personal.Repository.RowMapper;

import com.serviciosariana.app.personal.Model.Persona;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class PersonaRowMapper implements RowMapper<Persona> {
    @Override
    public Persona mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Persona.builder()
                .nPersonaId(rs.getInt("nPersonaId"))
                .nTipoDocumentoId(rs.getInt("nTipoDocumentoId"))
                .cTipoDocCod(rs.getString("cTipoDocCod"))
                .cTipoDocNombre(rs.getString("cTipoDocNombre"))
                .cNumeroDocumento(rs.getString("cNumeroDocumento"))
                .cNombres(rs.getString("cNombres"))
                .cApellidoPaterno(rs.getString("cApellidoPaterno"))
                .cApellidoMaterno(rs.getString("cApellidoMaterno"))
                .cSexo(rs.getString("cSexo"))
                .dFechaNacimiento(toLocalDate(rs.getDate("dFechaNacimiento")))
                .cTelefono(rs.getString("cTelefono"))
                .cEmail(rs.getString("cEmail"))
                .cDireccion(rs.getString("cDireccion"))
                .dFechaCreacion(toLocalDateTime(rs.getTimestamp("dFechaCreacion")))
                .bEstado(rs.getBoolean("bEstado"))
                .build();
    }

    private java.time.LocalDate toLocalDate(Date date) {
        return date != null ? date.toLocalDate() : null;
    }

    private java.time.LocalDateTime toLocalDateTime(Timestamp timestamp) {
        return timestamp != null ? timestamp.toLocalDateTime() : null;
    }
}