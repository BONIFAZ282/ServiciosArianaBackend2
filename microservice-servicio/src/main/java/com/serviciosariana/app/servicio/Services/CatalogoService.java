package com.serviciosariana.app.servicio.Services;

import com.serviciosariana.app.servicio.Model.EstadoOrden;
import com.serviciosariana.app.servicio.Model.Prioridad;
import com.serviciosariana.app.servicio.Model.TipoAlerta;
import com.serviciosariana.app.servicio.Model.dto.EstadoOrdenSimpleDTO;

import java.util.List;

public interface CatalogoService {
    List<Prioridad> listarPrioridades();
    List<EstadoOrden> listarEstadosOrden();
    List<EstadoOrdenSimpleDTO> listarEstadosSiguientes(String cEstadoOrdenCodActual);
    List<TipoAlerta> listarTiposAlerta();
}