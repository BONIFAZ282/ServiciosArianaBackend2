package com.serviciosariana.app.servicio.Repository.RowMapper;

import com.serviciosariana.app.servicio.Model.dto.RankingPersonalDTO;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class RankingPersonalRowMapper implements RowMapper<RankingPersonalDTO> {

    @Override
    public RankingPersonalDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return RankingPersonalDTO.builder()
                .nPersonalId(rs.getInt("nPersonalId"))
                .cNombreCompleto(rs.getString("cNombreCompleto"))
                .cCargoNombre(rs.getString("cCargoNombre"))
                .nTotalComoLider(rs.getInt("nTotalComoLider"))
                .nCompletadasComoLider(rs.getInt("nCompletadasComoLider"))
                .nActivasComoLider(rs.getInt("nActivasComoLider"))
                .nTotalComoMiembro(rs.getInt("nTotalComoMiembro"))
                .nCompletadasComoMiembro(rs.getInt("nCompletadasComoMiembro"))
                .nActivasComoMiembro(rs.getInt("nActivasComoMiembro"))
                .build();
    }
}