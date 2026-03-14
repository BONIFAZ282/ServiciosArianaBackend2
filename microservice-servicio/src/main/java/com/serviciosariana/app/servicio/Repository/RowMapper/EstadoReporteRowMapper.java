package com.serviciosariana.app.servicio.Repository.RowMapper;

import com.serviciosariana.app.servicio.Model.dto.EstadoReporteDTO;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class EstadoReporteRowMapper implements RowMapper<EstadoReporteDTO> {

    @Override
    public EstadoReporteDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return EstadoReporteDTO.builder()
                .cEstadoOrdenCod(rs.getString("cEstadoOrdenCod"))
                .cEstadoNombre(rs.getString("cEstadoNombre"))
                .cColor(rs.getString("cColor"))
                .nCantidad(rs.getInt("nCantidad"))
                .build();
    }
}