package com.serviciosariana.app.servicio.Repository.RowMapper;

import com.serviciosariana.app.servicio.Model.OrdenServicio;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class OrdenServicioRowMapper implements RowMapper<OrdenServicio> {

    @Override
    public OrdenServicio mapRow(ResultSet rs, int rowNum) throws SQLException {
        return OrdenServicio.builder()
                .nOrdenServicioId(rs.getInt("nOrdenServicioId"))
                .cOrdenServicioCod(rs.getString("cOrdenServicioCod"))
                .nClienteId(rs.getInt("nClienteId"))
                .cClienteNombre(rs.getString("cClienteNombre"))
                .nTipoServicioId(rs.getInt("nTipoServicioId"))
                .cTipoServicioNombre(rs.getString("cTipoServicioNombre"))
                .nPrioridadId(rs.getInt("nPrioridadId"))
                .cPrioridadNombre(rs.getString("cPrioridadNombre"))
                .cPrioridadColor(rs.getString("cPrioridadColor"))
                .nEstadoOrdenId(rs.getInt("nEstadoOrdenId"))
                .cEstadoOrdenCod(rs.getString("cEstadoOrdenCod"))
                .cEstadoOrdenNombre(rs.getString("cEstadoOrdenNombre"))
                .cEstadoOrdenColor(rs.getString("cEstadoOrdenColor"))
                .cTitulo(rs.getString("cTitulo"))
                .dFechaInicio(rs.getDate("dFechaInicio") != null ? rs.getDate("dFechaInicio").toLocalDate() : null)
                .dFechaFin(rs.getDate("dFechaFin") != null ? rs.getDate("dFechaFin").toLocalDate() : null)
                .nPersonalLiderId(rs.getObject("nPersonalLiderId") != null ? rs.getInt("nPersonalLiderId") : null)
                .cPersonalLiderNombre(rs.getString("cPersonalLiderNombre"))
                .nCostoEstimado(rs.getBigDecimal("nCostoEstimado"))
                .nTrabajadoresAsignados(rs.getInt("nTrabajadoresAsignados"))
                .build();
    }
}