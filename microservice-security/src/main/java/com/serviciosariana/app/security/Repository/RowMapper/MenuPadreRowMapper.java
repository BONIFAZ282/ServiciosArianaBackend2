package com.serviciosariana.app.security.Repository.RowMapper;

import com.serviciosariana.app.security.Model.dto.MenuPadreDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MenuPadreRowMapper implements RowMapper<MenuPadreDTO> {
    @Override
    public MenuPadreDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return MenuPadreDTO.builder()
                .nMenuId(rs.getInt("nMenuId"))
                .cMenuCod(rs.getString("cMenuCod"))
                .cNombre(rs.getString("cNombre"))
                .cIcono(rs.getString("cIcono"))
                .nOrden(rs.getInt("nOrden"))
                .build();
    }
}