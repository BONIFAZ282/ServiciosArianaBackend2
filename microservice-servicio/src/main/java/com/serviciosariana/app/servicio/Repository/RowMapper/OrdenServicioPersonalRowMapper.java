package com.serviciosariana.app.servicio.Repository.RowMapper;

import com.serviciosariana.app.servicio.Model.OrdenServicioPersonal;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class OrdenServicioPersonalRowMapper implements RowMapper<OrdenServicioPersonal> {

    @Override
    public OrdenServicioPersonal mapRow(ResultSet rs, int rowNum) throws SQLException {
        return OrdenServicioPersonal.builder()
                .nOrdenServicioPersonalId(rs.getInt("nOrdenServicioPersonalId"))
                .nOrdenServicioId(rs.getInt("nOrdenServicioId"))
                .nPersonalId(rs.getInt("nPersonalId"))
                .cPersonalNombre(rs.getString("cPersonalNombre"))
                .cTelefono(rs.getString("cTelefono"))
                .cEmail(rs.getString("cEmail"))
                .cCargoNombre(rs.getString("cCargoNombre"))
                .dFechaAsignacion(rs.getTimestamp("dFechaAsignacion") != null ? rs.getTimestamp("dFechaAsignacion").toLocalDateTime() : null)
                .cObservaciones(rs.getString("cObservaciones"))
                .bActivo(rs.getBoolean("bActivo"))
                .build();
    }
}