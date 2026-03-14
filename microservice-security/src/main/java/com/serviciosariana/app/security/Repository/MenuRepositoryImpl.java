package com.serviciosariana.app.security.Repository;

import com.serviciosariana.app.security.Model.Menu;
import com.serviciosariana.app.security.Model.dto.MenuPadreDTO;
import com.serviciosariana.app.security.Repository.RowMapper.MenuPadreRowMapper;
import com.serviciosariana.app.security.Repository.RowMapper.MenuRowMapper;
import com.serviciosariana.app.security.Repository.StoredProcedure.StoredProcedureMenu;
import com.serviciosariana.app.security.Repository.Translator.MenuTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class MenuRepositoryImpl implements MenuRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Menu> listarTodos() {
        String sql = StoredProcedureMenu.LST_TODOS;
        List<MenuTranslator> lista = jdbcTemplate.query(sql, new MenuRowMapper());
        return lista.stream()
                .map(MenuTranslator::toMenu)
                .collect(Collectors.toList());
    }

    @Override
    public List<MenuPadreDTO> listarPadres() {
        String sql = StoredProcedureMenu.LST_PADRES;
        return jdbcTemplate.query(sql, new MenuPadreRowMapper());
    }

    @Override
    public Optional<Menu> obtenerPorId(Integer nMenuId) {
        String sql = StoredProcedureMenu.GET_POR_ID;
        List<MenuTranslator> lista = jdbcTemplate.query(sql, new Object[]{nMenuId}, new MenuRowMapper());
        return lista.stream()
                .map(MenuTranslator::toMenu)
                .findFirst();
    }

    @Override
    public Integer insertar(String cMenuCod, String cNombre, String cDescripcion, String cRuta, String cIcono, Integer nMenuPadreId, Integer nOrden) {
        String sql = StoredProcedureMenu.INS_NUEVO;
        return jdbcTemplate.queryForObject(sql, new Object[]{cMenuCod, cNombre, cDescripcion, cRuta, cIcono, nMenuPadreId, nOrden}, Integer.class);
    }

    @Override
    public void actualizar(Integer nMenuId, String cMenuCod, String cNombre, String cDescripcion, String cRuta, String cIcono, Integer nMenuPadreId, Integer nOrden, Boolean bEstado) {
        String sql = StoredProcedureMenu.UPD_ACTUALIZAR;
        jdbcTemplate.update(sql, nMenuId, cMenuCod, cNombre, cDescripcion, cRuta, cIcono, nMenuPadreId, nOrden, bEstado);
    }

    @Override
    public void eliminar(Integer nMenuId) {
        String sql = StoredProcedureMenu.DEL_ELIMINAR;
        jdbcTemplate.update(sql, nMenuId);
    }
}