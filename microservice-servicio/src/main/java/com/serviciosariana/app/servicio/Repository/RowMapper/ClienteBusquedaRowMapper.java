package com.serviciosariana.app.servicio.Repository.RowMapper;

import com.serviciosariana.app.servicio.Model.dto.ClienteBusquedaDTO;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ClienteBusquedaRowMapper implements RowMapper<ClienteBusquedaDTO> {

    @Override
    public ClienteBusquedaDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return ClienteBusquedaDTO.builder()
                .nClienteId(rs.getObject("nClienteId") != null ? rs.getInt("nClienteId") : null)
                .cClienteCod(rs.getString("cClienteCod"))
                .cNumeroDocumento(rs.getString("cNumeroDocumento"))
                .cNombreCompleto(rs.getString("cNombreCompleto"))
                .cTelefono(rs.getString("cTelefono"))
                .cEmail(rs.getString("cEmail"))
                .bEncontrado(rs.getBoolean("bEncontrado"))
                .build();
    }
}