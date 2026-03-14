package com.serviciosariana.app.servicio.Repository;

import com.serviciosariana.app.servicio.Model.OrdenServicioDetalle;
import com.serviciosariana.app.servicio.Model.dto.OrdenTotalDTO;
import java.math.BigDecimal;
import java.util.List;

public interface OrdenServicioDetalleRepository {

    Integer agregar(Integer nOrdenServicioId, Integer nTipoServicioId, String cDescripcion,
                    Integer nCantidad, BigDecimal nPrecioUnitario);

    Integer actualizar(Integer nOrdenServicioDetalleId, String cDescripcion,
                       Integer nCantidad, BigDecimal nPrecioUnitario);

    void quitar(Integer nOrdenServicioDetalleId);

    List<OrdenServicioDetalle> listarPorOrden(Integer nOrdenServicioId);

    OrdenTotalDTO obtenerTotalOrden(Integer nOrdenServicioId);
}