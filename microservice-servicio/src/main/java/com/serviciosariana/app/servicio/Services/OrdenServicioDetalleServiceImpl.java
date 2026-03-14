package com.serviciosariana.app.servicio.Services;

import com.serviciosariana.app.servicio.Model.OrdenServicioDetalle;
import com.serviciosariana.app.servicio.Model.dto.OrdenServicioDetalleRequest;
import com.serviciosariana.app.servicio.Model.dto.OrdenTotalDTO;
import com.serviciosariana.app.servicio.Repository.OrdenServicioDetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdenServicioDetalleServiceImpl implements OrdenServicioDetalleService {

    @Autowired
    private OrdenServicioDetalleRepository ordenServicioDetalleRepository;

    @Override
    public Integer agregar(Integer nOrdenServicioId, OrdenServicioDetalleRequest request) {
        return ordenServicioDetalleRepository.agregar(
                nOrdenServicioId,
                request.getNTipoServicioId(),
                request.getCDescripcion(),
                request.getNCantidad(),
                request.getNPrecioUnitario()
        );
    }

    @Override
    public Integer actualizar(Integer nOrdenServicioDetalleId, OrdenServicioDetalleRequest request) {
        return ordenServicioDetalleRepository.actualizar(
                nOrdenServicioDetalleId,
                request.getCDescripcion(),
                request.getNCantidad(),
                request.getNPrecioUnitario()
        );
    }

    @Override
    public void quitar(Integer nOrdenServicioDetalleId) {
        ordenServicioDetalleRepository.quitar(nOrdenServicioDetalleId);
    }

    @Override
    public List<OrdenServicioDetalle> listarPorOrden(Integer nOrdenServicioId) {
        return ordenServicioDetalleRepository.listarPorOrden(nOrdenServicioId);
    }

    @Override
    public OrdenTotalDTO obtenerTotalOrden(Integer nOrdenServicioId) {
        return ordenServicioDetalleRepository.obtenerTotalOrden(nOrdenServicioId);
    }
}