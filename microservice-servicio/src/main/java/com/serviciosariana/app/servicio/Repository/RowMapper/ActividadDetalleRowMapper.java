package com.serviciosariana.app.servicio.Repository.RowMapper;

import com.serviciosariana.app.servicio.Model.Actividad;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ActividadDetalleRowMapper implements RowMapper<Actividad> {

    @Override
    public Actividad mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Actividad.builder()
                .nActividadId(rs.getInt("nActividadId"))
                .nOrdenServicioId(rs.getInt("nOrdenServicioId"))
                .cOrdenServicioCod(rs.getString("cOrdenServicioCod"))
                .cOrdenTitulo(rs.getString("cOrdenTitulo"))
                .nPersonalId(rs.getInt("nPersonalId"))
                .cPersonalNombre(rs.getString("cPersonalNombre"))
                .cTitulo(rs.getString("cTitulo"))
                .cDescripcion(rs.getString("cDescripcion"))
                .dFechaActividad(rs.getDate("dFechaActividad") != null ? rs.getDate("dFechaActividad").toLocalDate() : null)
                .dFechaCreacion(rs.getTimestamp("dFechaCreacion") != null ? rs.getTimestamp("dFechaCreacion").toLocalDateTime() : null)
                .nTotalEvidencias(rs.getInt("nTotalEvidencias"))
                .bEstado(rs.getBoolean("bEstado"))
                .build();
    }
}