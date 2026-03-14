package com.serviciosariana.app.servicio.Repository.RowMapper;

import com.serviciosariana.app.servicio.Model.dto.PrioridadReporteDTO;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class PrioridadReporteRowMapper implements RowMapper<PrioridadReporteDTO> {

    @Override
    public PrioridadReporteDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return PrioridadReporteDTO.builder()
                .cPrioridadCod(rs.getString("cPrioridadCod"))
                .cPrioridadNombre(rs.getString("cPrioridadNombre"))
                .cColor(rs.getString("cColor"))
                .nCantidad(rs.getInt("nCantidad"))
                .build();
    }
}