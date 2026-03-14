package com.serviciosariana.app.servicio.Repository.RowMapper;

import com.serviciosariana.app.servicio.Model.OrdenServicioDetalle;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ServicioItemRowMapper implements RowMapper<OrdenServicioDetalle> {

    @Override
    public OrdenServicioDetalle mapRow(ResultSet rs, int rowNum) throws SQLException {
        return OrdenServicioDetalle.builder()
                .nOrdenServicioDetalleId(rs.getInt("nOrdenServicioDetalleId"))
                .nOrdenServicioId(rs.getInt("nOrdenServicioId"))
                .nTipoServicioId(rs.getInt("nTipoServicioId"))
                .cTipoServicioCod(rs.getString("cTipoServicioCod"))
                .cTipoServicioNombre(rs.getString("cTipoServicioNombre"))
                .cDescripcion(rs.getString("cDescripcion"))
                .nCantidad(rs.getInt("nCantidad"))
                .nPrecioUnitario(rs.getBigDecimal("nPrecioUnitario"))
                .nSubtotal(rs.getBigDecimal("nSubtotal"))
                .bEstado(rs.getBoolean("bEstado"))
                .build();
    }
}