package com.serviciosariana.app.servicio.Repository.RowMapper;

import com.serviciosariana.app.servicio.Model.Cliente;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class ClienteRowMapper implements RowMapper<Cliente> {
    @Override
    public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Cliente.builder()
                .nClienteId(rs.getInt("nClienteId"))
                .cClienteCod(rs.getString("cClienteCod"))
                .nPersonaId(rs.getInt("nPersonaId"))
                .nTipoDocumentoId(rs.getInt("nTipoDocumentoId"))
                .cTipoDocCod(rs.getString("cTipoDocCod"))
                .cTipoDocNombre(rs.getString("cTipoDocNombre"))
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
                .cRazonSocial(rs.getString("cRazonSocial"))
                .cNombreComercial(rs.getString("cNombreComercial"))
                .cNombreMostrar(rs.getString("cNombreMostrar"))
                .dFechaRegistro(toLocalDateTime(rs.getTimestamp("dFechaRegistro")))
                .cObservaciones(rs.getString("cObservaciones"))
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