package com.serviciosariana.app.security.Repository;

import com.serviciosariana.app.security.Model.Menu;
import com.serviciosariana.app.security.Model.dto.MenuPadreDTO;

import java.util.List;
import java.util.Optional;

public interface MenuRepository {
    List<Menu> listarTodos();
    List<MenuPadreDTO> listarPadres();
    Optional<Menu> obtenerPorId(Integer nMenuId);
    Integer insertar(String cMenuCod, String cNombre, String cDescripcion, String cRuta, String cIcono, Integer nMenuPadreId, Integer nOrden);
    void actualizar(Integer nMenuId, String cMenuCod, String cNombre, String cDescripcion, String cRuta, String cIcono, Integer nMenuPadreId, Integer nOrden, Boolean bEstado);
    void eliminar(Integer nMenuId);
}