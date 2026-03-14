package com.serviciosariana.app.servicio.Repository.RowMapper;

import com.serviciosariana.app.servicio.Model.dto.OrdenResumenLiderDTO;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class OrdenResumenLiderRowMapper implements RowMapper<OrdenResumenLiderDTO> {

    @Override
    public OrdenResumenLiderDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return OrdenResumenLiderDTO.builder()
                .nOrdenServicioId(rs.getInt("nOrdenServicioId"))
                .cOrdenServicioCod(rs.getString("cOrdenServicioCod"))
                .cTitulo(rs.getString("cTitulo"))
                .cClienteNombre(rs.getString("cClienteNombre"))
                .cEstadoOrdenNombre(rs.getString("cEstadoOrdenNombre"))
                .cEstadoOrdenColor(rs.getString("cEstadoOrdenColor"))
                .cPrioridadNombre(rs.getString("cPrioridadNombre"))
                .cPrioridadColor(rs.getString("cPrioridadColor"))
                .dFechaInicio(rs.getDate("dFechaInicio") != null ? rs.getDate("dFechaInicio").toLocalDate() : null)
                .dFechaFin(rs.getDate("dFechaFin") != null ? rs.getDate("dFechaFin").toLocalDate() : null)
                .nTotalTrabajadores(rs.getInt("nTotalTrabajadores"))
                .nTotalServicios(rs.getInt("nTotalServicios"))
                .build();
    }
}