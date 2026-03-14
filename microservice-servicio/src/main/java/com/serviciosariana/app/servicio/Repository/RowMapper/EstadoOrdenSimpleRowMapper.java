package com.serviciosariana.app.servicio.Repository.RowMapper;

import com.serviciosariana.app.servicio.Model.dto.EstadoOrdenSimpleDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EstadoOrdenSimpleRowMapper implements RowMapper<EstadoOrdenSimpleDTO> {
    @Override
    public EstadoOrdenSimpleDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return EstadoOrdenSimpleDTO.builder()
                .nEstadoOrdenId(rs.getInt("nEstadoOrdenId"))
                .cEstadoOrdenCod(rs.getString("cEstadoOrdenCod"))
                .cNombre(rs.getString("cNombre"))
                .cColor(rs.getString("cColor"))
                .build();
    }
}