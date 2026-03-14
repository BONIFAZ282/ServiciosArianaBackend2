package com.serviciosariana.app.personal.Repository.RowMapper;

import com.serviciosariana.app.personal.Model.Personal;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class PersonalRowMapper implements RowMapper<Personal> {
    @Override
    public Personal mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Personal.builder()
                .nPersonalId(rs.getInt("nPersonalId"))
                .nPersonaId(rs.getInt("nPersonaId"))
                .cNumeroDocumento(rs.getString("cNumeroDocumento"))
                .cNombres(rs.getString("cNombres"))
                .cApellidoPaterno(rs.getString("cApellidoPaterno"))
                .cApellidoMaterno(rs.getString("cApellidoMaterno"))
                .cNombreCompleto(rs.getString("cNombreCompleto"))
                .cSexo(rs.getString("cSexo"))
                .dFechaNacimiento(toLocalDate(rs.getDate("dFechaNacimiento")))
                .cTelefono(rs.getString("cTelefono"))
                .cEmail(rs.getString("cEmail"))
                .cDireccion(rs.getString("cDireccion"))
                .nTipoDocumentoId(rs.getInt("nTipoDocumentoId"))
                .cTipoDocCod(rs.getString("cTipoDocCod"))
                .nCargoId(rs.getInt("nCargoId"))
                .cCargoCod(rs.getString("cCargoCod"))
                .cCargoNombre(rs.getString("cCargoNombre"))
                .nPersonalLiderId(rs.getObject("nPersonalLiderId") != null ? rs.getInt("nPersonalLiderId") : null)
                .cLiderNombre(rs.getString("cLiderNombre"))
                .dFechaIngreso(toLocalDate(rs.getDate("dFechaIngreso")))
                .dFechaCese(toLocalDate(rs.getDate("dFechaCese")))
                .nSueldo(rs.getBigDecimal("nSueldo"))
                .cObservaciones(rs.getString("cObservaciones"))
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