package com.serviciosariana.app.security.Repository.RowMapper;

import com.serviciosariana.app.security.Model.dto.MenuSidebarDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MenuSidebarRowMapper implements RowMapper<MenuSidebarDTO> {
    @Override
    public MenuSidebarDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return MenuSidebarDTO.builder()
                .nMenuId(rs.getInt("nMenuId"))
                .cMenuCod(rs.getString("cMenuCod"))
                .cNombre(rs.getString("cNombre"))
                .cRuta(rs.getString("cRuta"))
                .cIcono(rs.getString("cIcono"))
                .nMenuPadreId(rs.getObject("nMenuPadreId") != null ? rs.getInt("nMenuPadreId") : null)
                .nOrden(rs.getInt("nOrden"))
                .bVer(rs.getBoolean("bVer"))
                .bCrear(rs.getBoolean("bCrear"))
                .bEditar(rs.getBoolean("bEditar"))
                .bEliminar(rs.getBoolean("bEliminar"))
                .build();
    }
}