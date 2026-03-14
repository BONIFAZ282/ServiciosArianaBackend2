package com.serviciosariana.app.servicio.Repository.RowMapper;

import com.serviciosariana.app.servicio.Model.dto.ClienteListDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class ClienteListRowMapper implements RowMapper<ClienteListDTO> {
    @Override
    public ClienteListDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return ClienteListDTO.builder()
                .nClienteId(rs.getInt("nClienteId"))
                .cClienteCod(rs.getString("cClienteCod"))
                .cTipoDocCod(rs.getString("cTipoDocCod"))
                .cNumeroDocumento(rs.getString("cNumeroDocumento"))
                .cNombres(rs.getString("cNombres"))
                .cApellidoPaterno(rs.getString("cApellidoPaterno"))
                .cApellidoMaterno(rs.getString("cApellidoMaterno"))
                .cRazonSocial(rs.getString("cRazonSocial"))
                .cNombreComercial(rs.getString("cNombreComercial"))
                .cNombreMostrar(rs.getString("cNombreMostrar"))
                .cTelefono(rs.getString("cTelefono"))
                .cEmail(rs.getString("cEmail"))
                .cDireccion(rs.getString("cDireccion"))
                .dFechaRegistro(toLocalDateTime(rs.getTimestamp("dFechaRegistro")))
                .bEstado(rs.getBoolean("bEstado"))
                .build();
    }

    private java.time.LocalDateTime toLocalDateTime(Timestamp timestamp) {
        return timestamp != null ? timestamp.toLocalDateTime() : null;
    }
}