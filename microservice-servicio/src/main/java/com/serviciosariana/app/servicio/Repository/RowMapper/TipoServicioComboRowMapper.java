package com.serviciosariana.app.servicio.Repository.RowMapper;

import com.serviciosariana.app.servicio.Model.dto.TipoServicioComboDTO;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class TipoServicioComboRowMapper implements RowMapper<TipoServicioComboDTO> {

    @Override
    public TipoServicioComboDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return TipoServicioComboDTO.builder()
                .nTipoServicioId(rs.getInt("nTipoServicioId"))
                .cNombre(rs.getString("cNombre"))
                .nPrecioBase(rs.getBigDecimal("nPrecioBase"))
                .build();
    }
}