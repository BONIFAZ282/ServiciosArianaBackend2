package com.serviciosariana.app.servicio.Repository.RowMapper;

import com.serviciosariana.app.servicio.Model.dto.ContadorAlertasDTO;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ContadorAlertasRowMapper implements RowMapper<ContadorAlertasDTO> {

    @Override
    public ContadorAlertasDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return ContadorAlertasDTO.builder()
                .nTotalNoLeidas(rs.getInt("nTotalNoLeidas"))
                .nPorVencer(rs.getInt("nPorVencer"))
                .nVencidas(rs.getInt("nVencidas"))
                .build();
    }
}