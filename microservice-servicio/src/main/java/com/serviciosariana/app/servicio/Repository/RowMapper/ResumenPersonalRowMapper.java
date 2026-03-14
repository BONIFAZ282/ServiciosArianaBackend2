package com.serviciosariana.app.servicio.Repository.RowMapper;

import com.serviciosariana.app.servicio.Model.dto.ResumenPersonalDTO;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ResumenPersonalRowMapper implements RowMapper<ResumenPersonalDTO> {

    @Override
    public ResumenPersonalDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return ResumenPersonalDTO.builder()
                .nPersonalId(rs.getInt("nPersonalId"))
                .nOrdenesComoLider(rs.getInt("nOrdenesComoLider"))
                .nOrdenesCompletadasComoLider(rs.getInt("nOrdenesCompletadasComoLider"))
                .nOrdenesComoMiembro(rs.getInt("nOrdenesComoMiembro"))
                .nOrdenesActivasComoLider(rs.getInt("nOrdenesActivasComoLider"))
                .nOrdenesActivasComoMiembro(rs.getInt("nOrdenesActivasComoMiembro"))
                .nSubordinados(rs.getInt("nSubordinados"))
                .build();
    }
}