package com.serviciosariana.app.security.Repository.RowMapper;

import com.serviciosariana.app.security.Model.CargoMenu;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CargoMenuRowMapper implements RowMapper<CargoMenu> {
    @Override
    public CargoMenu mapRow(ResultSet rs, int rowNum) throws SQLException {
        return CargoMenu.builder()
                .nCargoMenuId(rs.getInt("nCargoMenuId"))
                .nCargoId(rs.getInt("nCargoId"))
                .nMenuId(rs.getInt("nMenuId"))
                .cMenuCod(rs.getString("cMenuCod"))
                .cMenuNombre(rs.getString("cMenuNombre"))
                .cRuta(rs.getString("cRuta"))
                .cIcono(rs.getString("cIcono"))
                .nMenuPadreId(rs.getObject("nMenuPadreId") != null ? rs.getInt("nMenuPadreId") : null)
                .cMenuPadreNombre(rs.getString("cMenuPadreNombre"))
                .nOrden(rs.getInt("nOrden"))
                .bVer(rs.getBoolean("bVer"))
                .bCrear(rs.getBoolean("bCrear"))
                .bEditar(rs.getBoolean("bEditar"))
                .bEliminar(rs.getBoolean("bEliminar"))
                .bEstado(rs.getBoolean("bEstado"))
                .build();
    }
}