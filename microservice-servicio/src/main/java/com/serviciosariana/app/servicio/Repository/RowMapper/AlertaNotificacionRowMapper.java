package com.serviciosariana.app.servicio.Repository.RowMapper;

import com.serviciosariana.app.servicio.Model.dto.AlertaNotificacionDTO;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class AlertaNotificacionRowMapper implements RowMapper<AlertaNotificacionDTO> {

    @Override
    public AlertaNotificacionDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return AlertaNotificacionDTO.builder()
                .nAlertaId(rs.getInt("nAlertaId"))
                .nOrdenServicioId(rs.getInt("nOrdenServicioId"))
                .cOrdenServicioCod(rs.getString("cOrdenServicioCod"))
                .cOrdenTitulo(rs.getString("cOrdenTitulo"))
                .cTipoAlertaCod(rs.getString("cTipoAlertaCod"))
                .cTipoAlertaNombre(rs.getString("cTipoAlertaNombre"))
                .cMensaje(rs.getString("cMensaje"))
                .dFechaGeneracion(rs.getTimestamp("dFechaGeneracion") != null ? rs.getTimestamp("dFechaGeneracion").toLocalDateTime() : null)
                .dFechaFin(rs.getDate("dFechaFin") != null ? rs.getDate("dFechaFin").toLocalDate() : null)
                .nDias(rs.getInt("nDias"))
                .nPersonalLiderId(rs.getObject("nPersonalLiderId") != null ? rs.getInt("nPersonalLiderId") : null)
                .cPersonalLiderNombre(rs.getString("cPersonalLiderNombre"))
                .cPersonalLiderEmail(rs.getString("cPersonalLiderEmail"))
                .cPrioridadNombre(rs.getString("cPrioridadNombre"))
                .cClienteNombre(rs.getString("cClienteNombre"))
                .build();
    }
}