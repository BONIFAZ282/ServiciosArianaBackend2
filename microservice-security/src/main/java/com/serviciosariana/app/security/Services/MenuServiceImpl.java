package com.serviciosariana.app.security.Services;

import com.serviciosariana.app.security.Model.Menu;
import com.serviciosariana.app.security.Model.dto.MenuPadreDTO;
import com.serviciosariana.app.security.Repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Override
    public List<Menu> listarTodos() {
        return menuRepository.listarTodos();
    }

    @Override
    public List<MenuPadreDTO> listarPadres() {
        return menuRepository.listarPadres();
    }

    @Override
    public Optional<Menu> obtenerPorId(Integer nMenuId) {
        return menuRepository.obtenerPorId(nMenuId);
    }

    @Override
    public Integer crear(String cMenuCod, String cNombre, String cDescripcion, String cRuta, String cIcono, Integer nMenuPadreId, Integer nOrden) {
        return menuRepository.insertar(cMenuCod, cNombre, cDescripcion, cRuta, cIcono, nMenuPadreId, nOrden);
    }

    @Override
    public void actualizar(Integer nMenuId, String cMenuCod, String cNombre, String cDescripcion, String cRuta, String cIcono, Integer nMenuPadreId, Integer nOrden, Boolean bEstado) {
        menuRepository.actualizar(nMenuId, cMenuCod, cNombre, cDescripcion, cRuta, cIcono, nMenuPadreId, nOrden, bEstado);
    }

    @Override
    public void eliminar(Integer nMenuId) {
        menuRepository.eliminar(nMenuId);
    }
}