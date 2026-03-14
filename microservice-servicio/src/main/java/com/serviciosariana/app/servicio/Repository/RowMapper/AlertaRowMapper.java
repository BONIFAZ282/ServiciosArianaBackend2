package com.serviciosariana.app.servicio.Repository.RowMapper;

import com.serviciosariana.app.servicio.Model.dto.AlertaDTO;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class AlertaRowMapper implements RowMapper<AlertaDTO> {

    @Override
    public AlertaDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return AlertaDTO.builder()
                .nAlertaId(rs.getInt("nAlertaId"))
                .nOrdenServicioId(rs.getInt("nOrdenServicioId"))
                .cOrdenServicioCod(rs.getString("cOrdenServicioCod"))
                .cOrdenTitulo(rs.getString("cOrdenTitulo"))
                .cClienteNombre(rs.getString("cClienteNombre"))
                .nTipoAlertaId(rs.getInt("nTipoAlertaId"))
                .cTipoAlertaCod(rs.getString("cTipoAlertaCod"))
                .cTipoAlertaNombre(rs.getString("cTipoAlertaNombre"))
                .cTipoAlertaColor(rs.getString("cTipoAlertaColor"))
                .cMensaje(rs.getString("cMensaje"))
                .dFechaGeneracion(rs.getTimestamp("dFechaGeneracion") != null ? rs.getTimestamp("dFechaGeneracion").toLocalDateTime() : null)
                .bLeida(rs.getBoolean("bLeida"))
                .dFechaLectura(rs.getTimestamp("dFechaLectura") != null ? rs.getTimestamp("dFechaLectura").toLocalDateTime() : null)
                .nPersonalLiderId(rs.getObject("nPersonalLiderId") != null ? rs.getInt("nPersonalLiderId") : null)
                .cPersonalLiderNombre(rs.getString("cPersonalLiderNombre"))
                .dFechaFin(rs.getDate("dFechaFin") != null ? rs.getDate("dFechaFin").toLocalDate() : null)
                .nDiasVencido(rs.getInt("nDiasVencido"))
                .cPrioridadNombre(rs.getString("cPrioridadNombre"))
                .cPrioridadColor(rs.getString("cPrioridadColor"))
                .cEstadoOrdenNombre(rs.getString("cEstadoOrdenNombre"))
                .cEstadoOrdenColor(rs.getString("cEstadoOrdenColor"))
                .build();
    }
}