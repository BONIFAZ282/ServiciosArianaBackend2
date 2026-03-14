package com.serviciosariana.app.servicio.Repository.RowMapper;

import com.serviciosariana.app.servicio.Model.dto.MesReporteDTO;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MesReporteRowMapper implements RowMapper<MesReporteDTO> {

    @Override
    public MesReporteDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return MesReporteDTO.builder()
                .nAnio(rs.getInt("nAnio"))
                .nMes(rs.getInt("nMes"))
                .cMesAnio(rs.getString("cMesAnio"))
                .nCantidad(rs.getInt("nCantidad"))
                .nIngresos(rs.getBigDecimal("nIngresos"))
                .build();
    }
}