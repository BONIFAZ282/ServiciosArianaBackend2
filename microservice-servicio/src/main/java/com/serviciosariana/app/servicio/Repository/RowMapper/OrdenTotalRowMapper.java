package com.serviciosariana.app.servicio.Repository.RowMapper;

import com.serviciosariana.app.servicio.Model.dto.OrdenTotalDTO;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class OrdenTotalRowMapper implements RowMapper<OrdenTotalDTO> {

    @Override
    public OrdenTotalDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return OrdenTotalDTO.builder()
                .nOrdenServicioId(rs.getInt("nOrdenServicioId"))
                .nCantidadServicios(rs.getInt("nCantidadServicios"))
                .nTotalServicios(rs.getBigDecimal("nTotalServicios"))
                .build();
    }
}