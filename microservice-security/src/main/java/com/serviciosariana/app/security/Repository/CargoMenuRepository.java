package com.serviciosariana.app.security.Repository;

import com.serviciosariana.app.security.Model.CargoMenu;
import com.serviciosariana.app.security.Model.dto.MenuSidebarDTO;

import java.util.List;

public interface CargoMenuRepository {
    List<CargoMenu> listarPorCargo(Integer nCargoId);
    List<MenuSidebarDTO> listarMenusSidebar(Integer nCargoId);
    List<MenuSidebarDTO> listarMenusPrincipal(Integer nCargoId);
    Integer asignar(Integer nCargoId, Integer nMenuId, Boolean bVer, Boolean bCrear, Boolean bEditar, Boolean bEliminar);
    void actualizarPermisos(Integer nCargoMenuId, Boolean bVer, Boolean bCrear, Boolean bEditar, Boolean bEliminar, Boolean bEstado);
    void eliminar(Integer nCargoMenuId);
    void eliminarTodosPorCargo(Integer nCargoId);
}