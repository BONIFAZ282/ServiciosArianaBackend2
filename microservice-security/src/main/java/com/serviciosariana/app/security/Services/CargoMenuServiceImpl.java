package com.serviciosariana.app.security.Services;

import com.serviciosariana.app.security.Model.CargoMenu;
import com.serviciosariana.app.security.Model.dto.MenuSidebarDTO;
import com.serviciosariana.app.security.Repository.CargoMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargoMenuServiceImpl implements CargoMenuService {

    @Autowired
    private CargoMenuRepository cargoMenuRepository;

    @Override
    public List<CargoMenu> listarPorCargo(Integer nCargoId) {
        return cargoMenuRepository.listarPorCargo(nCargoId);
    }

    @Override
    public List<MenuSidebarDTO> listarMenusSidebar(Integer nCargoId) {
        return cargoMenuRepository.listarMenusSidebar(nCargoId);
    }

    @Override
    public List<MenuSidebarDTO> listarMenusPrincipal(Integer nCargoId) {
        return cargoMenuRepository.listarMenusPrincipal(nCargoId);
    }

    @Override
    public Integer asignar(Integer nCargoId, Integer nMenuId, Boolean bVer, Boolean bCrear, Boolean bEditar, Boolean bEliminar) {
        return cargoMenuRepository.asignar(nCargoId, nMenuId, bVer, bCrear, bEditar, bEliminar);
    }

    @Override
    public void actualizarPermisos(Integer nCargoMenuId, Boolean bVer, Boolean bCrear, Boolean bEditar, Boolean bEliminar, Boolean bEstado) {
        cargoMenuRepository.actualizarPermisos(nCargoMenuId, bVer, bCrear, bEditar, bEliminar, bEstado);
    }

    @Override
    public void eliminar(Integer nCargoMenuId) {
        cargoMenuRepository.eliminar(nCargoMenuId);
    }

    @Override
    public void eliminarTodosPorCargo(Integer nCargoId) {
        cargoMenuRepository.eliminarTodosPorCargo(nCargoId);
    }
}