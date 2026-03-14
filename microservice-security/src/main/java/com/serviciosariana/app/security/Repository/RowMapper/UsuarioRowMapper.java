package com.serviciosariana.app.security.Repository.RowMapper;

import com.serviciosariana.app.security.Repository.Translator.UsuarioTranslator;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class UsuarioRowMapper implements RowMapper<UsuarioTranslator> {

    @Override
    public UsuarioTranslator mapRow(ResultSet rs, int rowNum) throws SQLException {
        return UsuarioTranslator.builder()
                .nUsuarioId(rs.getInt("nUsuarioId"))
                .nPersonalId(rs.getInt("nPersonalId"))
                .cUsuario(rs.getString("cUsuario"))
                .cPassword(getStringOrNull(rs, "cPassword"))
                .nIntentosFallidos(rs.getInt("nIntentosFallidos"))
                .dFechaBloqueo(toLocalDateTime(rs.getTimestamp("dFechaBloqueo")))
                .dFechaCreacion(toLocalDateTime(rs.getTimestamp("dFechaCreacion")))
                .dUltimoAcceso(toLocalDateTime(rs.getTimestamp("dUltimoAcceso")))
                .bPrimerAcceso(rs.getBoolean("bPrimerAcceso"))
                .bEstado(rs.getBoolean("bEstado"))
                .nCargoId(getIntOrNull(rs, "nCargoId"))
                .cCargoCod(getStringOrNull(rs, "cCargoCod"))
                .cCargoNombre(getStringOrNull(rs, "cCargoNombre"))
                .cNombres(getStringOrNull(rs, "cNombres"))
                .cApellidoPaterno(getStringOrNull(rs, "cApellidoPaterno"))
                .cApellidoMaterno(getStringOrNull(rs, "cApellidoMaterno"))
                .cNombreCompleto(getStringOrNull(rs, "cNombreCompleto"))
                .build();
    }

    private java.time.LocalDateTime toLocalDateTime(Timestamp timestamp) {
        return timestamp != null ? timestamp.toLocalDateTime() : null;
    }

    private String getStringOrNull(ResultSet rs, String columnName) {
        try {
            return rs.getString(columnName);
        } catch (SQLException e) {
            return null;
        }
    }

    private Integer getIntOrNull(ResultSet rs, String columnName) {
        try {
            int value = rs.getInt(columnName);
            return rs.wasNull() ? null : value;
        } catch (SQLException e) {
            return null;
        }
    }
}