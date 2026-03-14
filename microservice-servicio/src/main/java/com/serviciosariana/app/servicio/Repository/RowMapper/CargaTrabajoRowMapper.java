package com.serviciosariana.app.servicio.Repository.RowMapper;

import com.serviciosariana.app.servicio.Model.dto.CargaTrabajoDTO;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class CargaTrabajoRowMapper implements RowMapper<CargaTrabajoDTO> {

    @Override
    public CargaTrabajoDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return CargaTrabajoDTO.builder()
                .nPersonalId(rs.getInt("nPersonalId"))
                .cNombreCompleto(rs.getString("cNombreCompleto"))
                .cCargoNombre(rs.getString("cCargoNombre"))
                .nCargaComoLider(rs.getInt("nCargaComoLider"))
                .nCargaComoMiembro(rs.getInt("nCargaComoMiembro"))
                .build();
    }
}