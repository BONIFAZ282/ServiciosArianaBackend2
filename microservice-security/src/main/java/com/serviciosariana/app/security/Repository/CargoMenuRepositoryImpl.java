package com.serviciosariana.app.security.Repository;

import com.serviciosariana.app.security.Model.CargoMenu;
import com.serviciosariana.app.security.Model.dto.MenuSidebarDTO;
import com.serviciosariana.app.security.Repository.RowMapper.CargoMenuRowMapper;
import com.serviciosariana.app.security.Repository.RowMapper.MenuSidebarRowMapper;
import com.serviciosariana.app.security.Repository.StoredProcedure.StoredProcedureCargoMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CargoMenuRepositoryImpl implements CargoMenuRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<CargoMenu> listarPorCargo(Integer nCargoId) {
        String sql = StoredProcedureCargoMenu.LST_POR_CARGO;
        return jdbcTemplate.query(sql, new Object[]{nCargoId}, new CargoMenuRowMapper());
    }

    @Override
    public List<MenuSidebarDTO> listarMenusSidebar(Integer nCargoId) {
        String sql = StoredProcedureCargoMenu.LST_MENUS_SIDEBAR;
        return jdbcTemplate.query(sql, new Object[]{nCargoId}, new MenuSidebarRowMapper());
    }

    @Override
    public List<MenuSidebarDTO> listarMenusPrincipal(Integer nCargoId) {
        String sql = StoredProcedureCargoMenu.LST_MENUS_MAIN;
        return jdbcTemplate.query(sql, new Object[]{nCargoId}, new MenuSidebarRowMapper());
    }

    @Override
    public Integer asignar(Integer nCargoId, Integer nMenuId, Boolean bVer, Boolean bCrear, Boolean bEditar, Boolean bEliminar) {
        String sql = StoredProcedureCargoMenu.INS_ASIGNAR;
        return jdbcTemplate.queryForObject(sql, new Object[]{nCargoId, nMenuId, bVer, bCrear, bEditar, bEliminar}, Integer.class);
    }

    @Override
    public void actualizarPermisos(Integer nCargoMenuId, Boolean bVer, Boolean bCrear, Boolean bEditar, Boolean bEliminar, Boolean bEstado) {
        String sql = StoredProcedureCargoMenu.UPD_PERMISOS;
        jdbcTemplate.update(sql, nCargoMenuId, bVer, bCrear, bEditar, bEliminar, bEstado);
    }

    @Override
    public void eliminar(Integer nCargoMenuId) {
        String sql = StoredProcedureCargoMenu.DEL_ELIMINAR;
        jdbcTemplate.update(sql, nCargoMenuId);
    }

    @Override
    public void eliminarTodosPorCargo(Integer nCargoId) {
        String sql = StoredProcedureCargoMenu.DEL_TODOS_POR_CARGO;
        jdbcTemplate.update(sql, nCargoId);
    }
}