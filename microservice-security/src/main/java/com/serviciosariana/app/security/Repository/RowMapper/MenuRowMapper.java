package com.serviciosariana.app.security.Repository.RowMapper;

import com.serviciosariana.app.security.Repository.Translator.MenuTranslator;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class MenuRowMapper implements RowMapper<MenuTranslator> {
    @Override
    public MenuTranslator mapRow(ResultSet rs, int rowNum) throws SQLException {
        return MenuTranslator.builder()
                .nMenuId(rs.getInt("nMenuId"))
                .cMenuCod(rs.getString("cMenuCod"))
                .cNombre(rs.getString("cNombre"))
                .cDescripcion(rs.getString("cDescripcion"))
                .cRuta(rs.getString("cRuta"))
                .cIcono(rs.getString("cIcono"))
                .nMenuPadreId(rs.getObject("nMenuPadreId") != null ? rs.getInt("nMenuPadreId") : null)
                .cMenuPadreNombre(rs.getString("cMenuPadreNombre"))
                .nOrden(rs.getInt("nOrden"))
                .dFechaCreacion(toLocalDateTime(rs.getTimestamp("dFechaCreacion")))
                .bEstado(rs.getBoolean("bEstado"))
                .build();
    }

    private java.time.LocalDateTime toLocalDateTime(Timestamp timestamp) {
        return timestamp != null ? timestamp.toLocalDateTime() : null;
    }
}