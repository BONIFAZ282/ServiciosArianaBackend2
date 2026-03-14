package com.serviciosariana.app.servicio.Services;

import com.serviciosariana.app.servicio.Model.OrdenServicioDetalle;
import com.serviciosariana.app.servicio.Model.dto.OrdenServicioDetalleRequest;
import com.serviciosariana.app.servicio.Model.dto.OrdenTotalDTO;
import java.util.List;

public interface OrdenServicioDetalleService {

    Integer agregar(Integer nOrdenServicioId, OrdenServicioDetalleRequest request);

    Integer actualizar(Integer nOrdenServicioDetalleId, OrdenServicioDetalleRequest request);

    void quitar(Integer nOrdenServicioDetalleId);

    List<OrdenServicioDetalle> listarPorOrden(Integer nOrdenServicioId);

    OrdenTotalDTO obtenerTotalOrden(Integer nOrdenServicioId);
}