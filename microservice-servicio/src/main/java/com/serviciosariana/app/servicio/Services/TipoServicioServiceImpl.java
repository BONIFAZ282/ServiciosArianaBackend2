package com.serviciosariana.app.servicio.Services;

import com.serviciosariana.app.servicio.Model.TipoServicio;
import com.serviciosariana.app.servicio.Model.dto.TipoServicioComboDTO;
import com.serviciosariana.app.servicio.Model.dto.TipoServicioRequest;
import com.serviciosariana.app.servicio.Repository.TipoServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoServicioServiceImpl implements TipoServicioService {

    @Autowired
    private TipoServicioRepository tipoServicioRepository;

    @Override
    public List<TipoServicio> listarTodos() {
        return tipoServicioRepository.listarTodos();
    }

    @Override
    public Integer crear(TipoServicioRequest request) {
        return tipoServicioRepository.insertar(
                request.getCTipoServicioCod(),
                request.getCNombre(),
                request.getCDescripcion(),
                request.getNPrecioBase()
        );
    }

    @Override
    public void actualizar(Integer nTipoServicioId, TipoServicioRequest request) {
        tipoServicioRepository.actualizar(
                nTipoServicioId,
                request.getCTipoServicioCod(),
                request.getCNombre(),
                request.getCDescripcion(),
                request.getNPrecioBase(),
                request.getBEstado()
        );
    }

    @Override
    public void eliminar(Integer nTipoServicioId) {
        tipoServicioRepository.eliminar(nTipoServicioId);
    }

    @Override
    public List<TipoServicioComboDTO> listarParaCombo() {
        return tipoServicioRepository.listarParaCombo();
    }
}