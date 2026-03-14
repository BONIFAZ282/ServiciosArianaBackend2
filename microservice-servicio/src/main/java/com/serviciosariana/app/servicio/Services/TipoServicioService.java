package com.serviciosariana.app.servicio.Services;

import com.serviciosariana.app.servicio.Model.TipoServicio;
import com.serviciosariana.app.servicio.Model.dto.TipoServicioComboDTO;
import com.serviciosariana.app.servicio.Model.dto.TipoServicioRequest;

import java.util.List;

public interface TipoServicioService {
    List<TipoServicio> listarTodos();
    Integer crear(TipoServicioRequest request);
    void actualizar(Integer nTipoServicioId, TipoServicioRequest request);
    void eliminar(Integer nTipoServicioId);
    List<TipoServicioComboDTO> listarParaCombo();
}