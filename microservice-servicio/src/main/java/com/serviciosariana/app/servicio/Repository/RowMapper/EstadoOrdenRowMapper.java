package com.serviciosariana.app.servicio.Repository.RowMapper;

import com.serviciosariana.app.servicio.Model.EstadoOrden;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EstadoOrdenRowMapper implements RowMapper<EstadoOrden> {
    @Override
    public EstadoOrden mapRow(ResultSet rs, int rowNum) throws SQLException {
        return EstadoOrden.builder()
                .nEstadoOrdenId(rs.getInt("nEstadoOrdenId"))
                .cEstadoOrdenCod(rs.getString("cEstadoOrdenCod"))
                .cNombre(rs.getString("cNombre"))
                .cDescripcion(rs.getString("cDescripcion"))
                .cColor(rs.getString("cColor"))
                .nOrden(rs.getInt("nOrden"))
                .bPermiteEditar(rs.getBoolean("bPermiteEditar"))
                .build();
    }
}