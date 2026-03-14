package com.serviciosariana.app.security.Repository.RowMapper;

import com.serviciosariana.app.security.Model.dto.UsuarioListDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class UsuarioListRowMapper implements RowMapper<UsuarioListDTO> {

    @Override
    public UsuarioListDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return UsuarioListDTO.builder()
                .nUsuarioId(rs.getInt("nUsuarioId"))
                .nPersonalId(rs.getInt("nPersonalId"))
                .cUsuario(rs.getString("cUsuario"))
                .nIntentosFallidos(rs.getInt("nIntentosFallidos"))
                .dFechaBloqueo(toLocalDateTime(rs.getTimestamp("dFechaBloqueo")))
                .dFechaCreacion(toLocalDateTime(rs.getTimestamp("dFechaCreacion")))
                .dUltimoAcceso(toLocalDateTime(rs.getTimestamp("dUltimoAcceso")))
                .bPrimerAcceso(rs.getBoolean("bPrimerAcceso"))
                .bEstado(rs.getBoolean("bEstado"))
                .cNombreCompleto(rs.getString("cNombreCompleto"))
                .cCargoNombre(rs.getString("cCargoNombre"))
                .build();
    }

    private java.time.LocalDateTime toLocalDateTime(Timestamp timestamp) {
        return timestamp != null ? timestamp.toLocalDateTime() : null;
    }
}