package com.serviciosariana.app.servicio.Repository.RowMapper;

import com.serviciosariana.app.servicio.Model.OrdenServicioHistorial;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class OrdenServicioHistorialRowMapper implements RowMapper<OrdenServicioHistorial> {

    @Override
    public OrdenServicioHistorial mapRow(ResultSet rs, int rowNum) throws SQLException {
        return OrdenServicioHistorial.builder()
                .nOrdenServicioHistorialId(rs.getInt("nOrdenServicioHistorialId"))
                .cEstadoAnterior(rs.getString("cEstadoAnterior"))
                .cEstadoAnteriorColor(rs.getString("cEstadoAnteriorColor"))
                .cEstadoNuevo(rs.getString("cEstadoNuevo"))
                .cEstadoNuevoColor(rs.getString("cEstadoNuevoColor"))
                .cComentario(rs.getString("cComentario"))
                .dFechaCambio(rs.getTimestamp("dFechaCambio") != null ? rs.getTimestamp("dFechaCambio").toLocalDateTime() : null)
                .cUsuarioNombre(rs.getString("cUsuarioNombre"))
                .build();
    }
}