package com.serviciosariana.app.servicio.Repository.RowMapper;

import com.serviciosariana.app.servicio.Model.dto.OrdenVencidaDTO;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class OrdenVencidaRowMapper implements RowMapper<OrdenVencidaDTO> {

    @Override
    public OrdenVencidaDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return OrdenVencidaDTO.builder()
                .nOrdenServicioId(rs.getInt("nOrdenServicioId"))
                .cOrdenServicioCod(rs.getString("cOrdenServicioCod"))
                .cTitulo(rs.getString("cTitulo"))
                .cClienteNombre(rs.getString("cClienteNombre"))
                .cEstadoNombre(rs.getString("cEstadoNombre"))
                .cEstadoColor(rs.getString("cEstadoColor"))
                .cPrioridadNombre(rs.getString("cPrioridadNombre"))
                .cPrioridadColor(rs.getString("cPrioridadColor"))
                .dFechaFin(rs.getDate("dFechaFin") != null ? rs.getDate("dFechaFin").toLocalDate() : null)
                .nDiasVencido(rs.getInt("nDiasVencido"))
                .cLiderNombre(rs.getString("cLiderNombre"))
                .build();
    }
}