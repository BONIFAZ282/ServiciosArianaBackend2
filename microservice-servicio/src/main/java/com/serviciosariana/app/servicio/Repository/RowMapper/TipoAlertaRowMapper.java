package com.serviciosariana.app.servicio.Repository.RowMapper;

import com.serviciosariana.app.servicio.Model.TipoAlerta;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TipoAlertaRowMapper implements RowMapper<TipoAlerta> {
    @Override
    public TipoAlerta mapRow(ResultSet rs, int rowNum) throws SQLException {
        return TipoAlerta.builder()
                .nTipoAlertaId(rs.getInt("nTipoAlertaId"))
                .cTipoAlertaCod(rs.getString("cTipoAlertaCod"))
                .cNombre(rs.getString("cNombre"))
                .cDescripcion(rs.getString("cDescripcion"))
                .cColor(rs.getString("cColor"))
                .build();
    }
}