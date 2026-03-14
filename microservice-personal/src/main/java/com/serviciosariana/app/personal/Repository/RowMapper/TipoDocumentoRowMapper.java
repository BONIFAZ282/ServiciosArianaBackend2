package com.serviciosariana.app.personal.Repository.RowMapper;

import com.serviciosariana.app.personal.Model.TipoDocumento;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TipoDocumentoRowMapper implements RowMapper<TipoDocumento> {
    @Override
    public TipoDocumento mapRow(ResultSet rs, int rowNum) throws SQLException {
        return TipoDocumento.builder()
                .nTipoDocumentoId(rs.getInt("nTipoDocumentoId"))
                .cTipoDocCod(rs.getString("cTipoDocCod"))
                .cNombre(rs.getString("cNombre"))
                .cDescripcion(rs.getString("cDescripcion"))
                .nLongitud(rs.getInt("nLongitud"))
                .bEstado(rs.getBoolean("bEstado"))
                .build();
    }
}