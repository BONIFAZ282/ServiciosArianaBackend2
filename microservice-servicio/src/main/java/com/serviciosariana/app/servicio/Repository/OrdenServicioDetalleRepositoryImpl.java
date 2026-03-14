package com.serviciosariana.app.servicio.Repository;

import com.serviciosariana.app.servicio.Model.OrdenServicioDetalle;
import com.serviciosariana.app.servicio.Model.dto.OrdenTotalDTO;
import com.serviciosariana.app.servicio.Repository.RowMapper.OrdenServicioDetalleRowMapper;
import com.serviciosariana.app.servicio.Repository.RowMapper.OrdenTotalRowMapper;
import com.serviciosariana.app.servicio.Repository.RowMapper.ServicioItemRowMapper;
import com.serviciosariana.app.servicio.Repository.StoredProcedure.StoredProcedureOrdenServicioDetalle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Repository
public class OrdenServicioDetalleRepositoryImpl implements OrdenServicioDetalleRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ServicioItemRowMapper servicioItemRowMapper;

    @Autowired
    private OrdenTotalRowMapper ordenTotalRowMapper;

    @Override
    public Integer agregar(Integer nOrdenServicioId, Integer nTipoServicioId, String cDescripcion,
                           Integer nCantidad, BigDecimal nPrecioUnitario) {
        List<Map<String, Object>> result = jdbcTemplate.queryForList(
                StoredProcedureOrdenServicioDetalle.SP_AGREGAR,
                nOrdenServicioId, nTipoServicioId, cDescripcion, nCantidad, nPrecioUnitario
        );
        return result.isEmpty() ? null : ((Number) result.get(0).get("nOrdenServicioDetalleId")).intValue();
    }

    @Override
    public Integer actualizar(Integer nOrdenServicioDetalleId, String cDescripcion,
                              Integer nCantidad, BigDecimal nPrecioUnitario) {
        List<Map<String, Object>> result = jdbcTemplate.queryForList(
                StoredProcedureOrdenServicioDetalle.SP_ACTUALIZAR,
                nOrdenServicioDetalleId, cDescripcion, nCantidad, nPrecioUnitario
        );
        return result.isEmpty() ? null : ((Number) result.get(0).get("nOrdenServicioDetalleId")).intValue();
    }

    @Override
    public void quitar(Integer nOrdenServicioDetalleId) {
        jdbcTemplate.queryForList(StoredProcedureOrdenServicioDetalle.SP_QUITAR, nOrdenServicioDetalleId);
    }

    @Override
    public List<OrdenServicioDetalle> listarPorOrden(Integer nOrdenServicioId) {
        return jdbcTemplate.query(
                StoredProcedureOrdenServicioDetalle.SP_LISTAR_POR_ORDEN,
                servicioItemRowMapper,
                nOrdenServicioId
        );
    }

    @Override
    public OrdenTotalDTO obtenerTotalOrden(Integer nOrdenServicioId) {
        List<OrdenTotalDTO> result = jdbcTemplate.query(
                StoredProcedureOrdenServicioDetalle.SP_TOTAL_ORDEN,
                ordenTotalRowMapper,
                nOrdenServicioId
        );
        return result.isEmpty() ? null : result.get(0);
    }
}