package com.serviciosariana.app.servicio.Services;

import com.serviciosariana.app.servicio.Model.OrdenServicio;
import com.serviciosariana.app.servicio.Model.OrdenServicioHistorial;
import com.serviciosariana.app.servicio.Model.dto.OrdenServicioCreatedDTO;
import com.serviciosariana.app.servicio.Model.dto.OrdenServicioRequest;
import com.serviciosariana.app.servicio.Repository.OrdenServicioRepository;

import com.serviciosariana.app.servicio.Model.dto.EquipoLiderDTO;
import com.serviciosariana.app.servicio.Model.dto.OrdenResumenLiderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdenServicioServiceImpl implements OrdenServicioService {

    @Autowired
    private OrdenServicioRepository ordenServicioRepository;

    @Override
    public OrdenServicioCreatedDTO crear(OrdenServicioRequest request) {
        return ordenServicioRepository.insertar(
                request.getNClienteId(),
                request.getNTipoServicioId(),
                request.getNPrioridadId(),
                request.getCTitulo(),
                request.getCDescripcion(),
                request.getDFechaInicio(),
                request.getDFechaFin(),
                request.getNPersonalLiderId(),
                request.getCDireccionServicio(),
                request.getNCostoEstimado(),
                request.getCObservaciones(),
                request.getNUsuarioCreacionId()
        );
    }

    @Override
    public Integer actualizar(Integer nOrdenServicioId, OrdenServicioRequest request) {
        return ordenServicioRepository.actualizar(
                nOrdenServicioId,
                request.getNClienteId(),
                request.getNTipoServicioId(),
                request.getNPrioridadId(),
                request.getCTitulo(),
                request.getCDescripcion(),
                request.getDFechaInicio(),
                request.getDFechaFin(),
                request.getNPersonalLiderId(),
                request.getCDireccionServicio(),
                request.getNCostoEstimado(),
                request.getNCostoReal(),
                request.getCObservaciones()
        );
    }

    @Override
    public void cambiarEstado(Integer nOrdenServicioId, String cEstadoOrdenCodNuevo, String cComentario, Integer nUsuarioId) {
        ordenServicioRepository.cambiarEstado(nOrdenServicioId, cEstadoOrdenCodNuevo, cComentario, nUsuarioId);
    }

    @Override
    public void eliminar(Integer nOrdenServicioId) {
        ordenServicioRepository.eliminar(nOrdenServicioId);
    }

    @Override
    public OrdenServicio obtenerPorId(Integer nOrdenServicioId) {
        return ordenServicioRepository.obtenerPorId(nOrdenServicioId)
                .orElseThrow(() -> new RuntimeException("Orden de servicio no encontrada"));
    }

    @Override
    public List<OrdenServicio> listarTodos() {
        return ordenServicioRepository.listarTodos();
    }

    @Override
    public List<OrdenServicioHistorial> listarHistorial(Integer nOrdenServicioId) {
        return ordenServicioRepository.listarHistorial(nOrdenServicioId);
    }

    @Override
    public List<EquipoLiderDTO> listarEquipoPorLider(Integer nPersonalLiderId) {
        return ordenServicioRepository.listarEquipoPorLider(nPersonalLiderId);
    }

    @Override
    public List<OrdenResumenLiderDTO> listarResumenPorLider(Integer nPersonalLiderId) {
        return ordenServicioRepository.listarResumenPorLider(nPersonalLiderId);
    }
}