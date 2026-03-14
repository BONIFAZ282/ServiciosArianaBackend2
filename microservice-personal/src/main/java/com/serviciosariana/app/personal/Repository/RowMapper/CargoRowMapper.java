package com.serviciosariana.app.personal.Repository.RowMapper;

import com.serviciosariana.app.personal.Model.Cargo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class CargoRowMapper implements RowMapper<Cargo> {
    @Override
    public Cargo mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Cargo.builder()
                .nCargoId(rs.getInt("nCargoId"))
                .cCargoCod(rs.getString("cCargoCod"))
                .cNombre(rs.getString("cNombre"))
                .cDescripcion(rs.getString("cDescripcion"))
                .dFechaCreacion(toLocalDateTime(rs.getTimestamp("dFechaCreacion")))
                .bEstado(rs.getBoolean("bEstado"))
                .build();
    }

    private java.time.LocalDateTime toLocalDateTime(Timestamp timestamp) {
        return timestamp != null ? timestamp.toLocalDateTime() : null;
    }
}