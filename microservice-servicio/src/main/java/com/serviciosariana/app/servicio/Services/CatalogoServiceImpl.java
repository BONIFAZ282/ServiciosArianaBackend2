package com.serviciosariana.app.servicio.Services;

import com.serviciosariana.app.servicio.Model.EstadoOrden;
import com.serviciosariana.app.servicio.Model.Prioridad;
import com.serviciosariana.app.servicio.Model.TipoAlerta;
import com.serviciosariana.app.servicio.Model.dto.EstadoOrdenSimpleDTO;
import com.serviciosariana.app.servicio.Repository.CatalogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogoServiceImpl implements CatalogoService {

    @Autowired
    private CatalogoRepository catalogoRepository;

    @Override
    public List<Prioridad> listarPrioridades() {
        return catalogoRepository.listarPrioridades();
    }

    @Override
    public List<EstadoOrden> listarEstadosOrden() {
        return catalogoRepository.listarEstadosOrden();
    }

    @Override
    public List<EstadoOrdenSimpleDTO> listarEstadosSiguientes(String cEstadoOrdenCodActual) {
        return catalogoRepository.listarEstadosSiguientes(cEstadoOrdenCodActual);
    }

    @Override
    public List<TipoAlerta> listarTiposAlerta() {
        return catalogoRepository.listarTiposAlerta();
    }
}