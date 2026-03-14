package com.serviciosariana.app.personal.Repository.RowMapper;

import com.serviciosariana.app.personal.Model.dto.PersonalConLiderDTO;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class PersonalConLiderRowMapper implements RowMapper<PersonalConLiderDTO> {

    @Override
    public PersonalConLiderDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return PersonalConLiderDTO.builder()
                .nPersonalId(rs.getInt("nPersonalId"))
                .cNombreCompleto(rs.getString("cNombreCompleto"))
                .nCargoId(rs.getInt("nCargoId"))
                .cCargoNombre(rs.getString("cCargoNombre"))
                .cTelefono(rs.getString("cTelefono"))
                .nPersonalLiderId(rs.getObject("nPersonalLiderId") != null ? rs.getInt("nPersonalLiderId") : null)
                .cLiderNombre(rs.getString("cLiderNombre"))
                .build();
    }
}