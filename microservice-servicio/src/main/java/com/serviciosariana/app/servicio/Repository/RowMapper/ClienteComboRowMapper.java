package com.serviciosariana.app.servicio.Repository.RowMapper;

import com.serviciosariana.app.servicio.Model.dto.ClienteComboDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteComboRowMapper implements RowMapper<ClienteComboDTO> {
    @Override
    public ClienteComboDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return ClienteComboDTO.builder()
                .nClienteId(rs.getInt("nClienteId"))
                .cClienteCod(rs.getString("cClienteCod"))
                .cNombreMostrar(rs.getString("cNombreMostrar"))
                .cNumeroDocumento(rs.getString("cNumeroDocumento"))
                .build();
    }
}