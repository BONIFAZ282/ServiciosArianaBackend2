package com.serviciosariana.app.servicio.Repository.RowMapper;

import com.serviciosariana.app.servicio.Model.TipoServicio;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class TipoServicioRowMapper implements RowMapper<TipoServicio> {
    @Override
    public TipoServicio mapRow(ResultSet rs, int rowNum) throws SQLException {
        return TipoServicio.builder()
                .nTipoServicioId(rs.getInt("nTipoServicioId"))
                .cTipoServicioCod(rs.getString("cTipoServicioCod"))
                .cNombre(rs.getString("cNombre"))
                .cDescripcion(rs.getString("cDescripcion"))
                .nPrecioBase(rs.getBigDecimal("nPrecioBase"))
                .dFechaCreacion(toLocalDateTime(rs.getTimestamp("dFechaCreacion")))
                .bEstado(rs.getBoolean("bEstado"))
                .build();
    }

    private java.time.LocalDateTime toLocalDateTime(Timestamp timestamp) {
        return timestamp != null ? timestamp.toLocalDateTime() : null;
    }
}