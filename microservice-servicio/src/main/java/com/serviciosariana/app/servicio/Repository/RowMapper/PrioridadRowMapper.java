package com.serviciosariana.app.servicio.Repository.RowMapper;

import com.serviciosariana.app.servicio.Model.Prioridad;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PrioridadRowMapper implements RowMapper<Prioridad> {
    @Override
    public Prioridad mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Prioridad.builder()
                .nPrioridadId(rs.getInt("nPrioridadId"))
                .cPrioridadCod(rs.getString("cPrioridadCod"))
                .cNombre(rs.getString("cNombre"))
                .nDiasAlerta(rs.getInt("nDiasAlerta"))
                .cColor(rs.getString("cColor"))
                .nOrden(rs.getInt("nOrden"))
                .build();
    }
}