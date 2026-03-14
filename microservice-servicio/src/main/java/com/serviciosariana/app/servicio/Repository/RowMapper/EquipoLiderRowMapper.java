package com.serviciosariana.app.servicio.Repository.RowMapper;

import com.serviciosariana.app.servicio.Model.dto.EquipoLiderDTO;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class EquipoLiderRowMapper implements RowMapper<EquipoLiderDTO> {

    @Override
    public EquipoLiderDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return EquipoLiderDTO.builder()
                .nOrdenServicioId(rs.getInt("nOrdenServicioId"))
                .cOrdenServicioCod(rs.getString("cOrdenServicioCod"))
                .cTitulo(rs.getString("cTitulo"))
                .cEstadoOrdenNombre(rs.getString("cEstadoOrdenNombre"))
                .cEstadoOrdenColor(rs.getString("cEstadoOrdenColor"))
                .dFechaInicio(rs.getDate("dFechaInicio") != null ? rs.getDate("dFechaInicio").toLocalDate() : null)
                .dFechaFin(rs.getDate("dFechaFin") != null ? rs.getDate("dFechaFin").toLocalDate() : null)
                .nTrabajadorId(rs.getObject("nTrabajadorId") != null ? rs.getInt("nTrabajadorId") : null)
                .cTrabajadorNombre(rs.getString("cTrabajadorNombre"))
                .cTrabajadorCargo(rs.getString("cTrabajadorCargo"))
                .cTrabajadorTelefono(rs.getString("cTrabajadorTelefono"))
                .dFechaAsignacion(rs.getTimestamp("dFechaAsignacion") != null ? rs.getTimestamp("dFechaAsignacion").toLocalDateTime() : null)
                .build();
    }
}