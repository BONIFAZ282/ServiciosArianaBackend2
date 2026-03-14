package com.serviciosariana.app.servicio.Repository.RowMapper;

import com.serviciosariana.app.servicio.Model.dto.PersonalDisponibleDTO;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class PersonalDisponibleRowMapper implements RowMapper<PersonalDisponibleDTO> {

    @Override
    public PersonalDisponibleDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return PersonalDisponibleDTO.builder()
                .nPersonalId(rs.getInt("nPersonalId"))
                .cPersonalNombre(rs.getString("cPersonalNombre"))
                .cCargoNombre(rs.getString("cCargoNombre"))
                .cTelefono(rs.getString("cTelefono"))
                .build();
    }
}