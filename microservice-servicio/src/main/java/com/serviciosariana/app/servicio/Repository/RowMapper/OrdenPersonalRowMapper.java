package com.serviciosariana.app.servicio.Repository.RowMapper;

import com.serviciosariana.app.servicio.Model.dto.OrdenPersonalDTO;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class OrdenPersonalRowMapper implements RowMapper<OrdenPersonalDTO> {

    @Override
    public OrdenPersonalDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return OrdenPersonalDTO.builder()
                .nOrdenServicioId(rs.getInt("nOrdenServicioId"))
                .cOrdenServicioCod(rs.getString("cOrdenServicioCod"))
                .cTitulo(rs.getString("cTitulo"))
                .cClienteNombre(rs.getString("cClienteNombre"))
                .cEstadoOrdenCod(rs.getString("cEstadoOrdenCod"))
                .cEstadoNombre(rs.getString("cEstadoNombre"))
                .cEstadoColor(rs.getString("cEstadoColor"))
                .cPrioridadNombre(rs.getString("cPrioridadNombre"))
                .cPrioridadColor(rs.getString("cPrioridadColor"))
                .dFechaInicio(rs.getDate("dFechaInicio") != null ? rs.getDate("dFechaInicio").toLocalDate() : null)
                .dFechaFin(rs.getDate("dFechaFin") != null ? rs.getDate("dFechaFin").toLocalDate() : null)
                .nPersonalLiderId(rs.getObject("nPersonalLiderId") != null ? rs.getInt("nPersonalLiderId") : null)
                .cPersonalLiderNombre(rs.getString("cPersonalLiderNombre"))
                .cRol(rs.getString("cRol"))
                .cTipoServicioNombre(rs.getString("cTipoServicioNombre"))
                .build();
    }
}