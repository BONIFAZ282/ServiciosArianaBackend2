package com.serviciosariana.app.servicio.Repository;

import com.serviciosariana.app.servicio.Model.TipoServicio;
import com.serviciosariana.app.servicio.Model.dto.TipoServicioComboDTO;

import java.math.BigDecimal;
import java.util.List;

public interface TipoServicioRepository {
    List<TipoServicio> listarTodos();
    Integer insertar(String cTipoServicioCod, String cNombre, String cDescripcion, BigDecimal nPrecioBase);
    void actualizar(Integer nTipoServicioId, String cTipoServicioCod, String cNombre, String cDescripcion, BigDecimal nPrecioBase, Boolean bEstado);
    void eliminar(Integer nTipoServicioId);
    List<TipoServicioComboDTO> listarParaCombo();
}