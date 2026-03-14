package com.serviciosariana.app.personal.Repository.RowMapper;

import com.serviciosariana.app.personal.Model.dto.LiderDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LiderRowMapper implements RowMapper<LiderDTO> {
    @Override
    public LiderDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return LiderDTO.builder()
                .nPersonalId(rs.getInt("nPersonalId"))
                .cNombreCompleto(rs.getString("cNombreCompleto"))
                .cCargoNombre(rs.getString("cCargoNombre"))
                .build();
    }
}