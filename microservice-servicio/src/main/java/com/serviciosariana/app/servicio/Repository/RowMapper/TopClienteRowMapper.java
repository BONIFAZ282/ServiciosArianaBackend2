package com.serviciosariana.app.servicio.Repository.RowMapper;

import com.serviciosariana.app.servicio.Model.dto.TopClienteDTO;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class TopClienteRowMapper implements RowMapper<TopClienteDTO> {

    @Override
    public TopClienteDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return TopClienteDTO.builder()
                .nClienteId(rs.getInt("nClienteId"))
                .cClienteNombre(rs.getString("cClienteNombre"))
                .nTotalOrdenes(rs.getInt("nTotalOrdenes"))
                .nTotalFacturado(rs.getBigDecimal("nTotalFacturado"))
                .build();
    }
}