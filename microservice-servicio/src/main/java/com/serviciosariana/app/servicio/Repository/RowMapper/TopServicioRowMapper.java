package com.serviciosariana.app.servicio.Repository.RowMapper;

import com.serviciosariana.app.servicio.Model.dto.TopServicioDTO;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class TopServicioRowMapper implements RowMapper<TopServicioDTO> {

    @Override
    public TopServicioDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return TopServicioDTO.builder()
                .nTipoServicioId(rs.getInt("nTipoServicioId"))
                .cTipoServicioNombre(rs.getString("cTipoServicioNombre"))
                .nVecesSolicitado(rs.getInt("nVecesSolicitado"))
                .nTotalGenerado(rs.getBigDecimal("nTotalGenerado"))
                .build();
    }
}