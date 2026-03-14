package com.serviciosariana.app.servicio.Repository.RowMapper;

import com.serviciosariana.app.servicio.Model.ActividadEvidencia;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ActividadEvidenciaRowMapper implements RowMapper<ActividadEvidencia> {

    @Override
    public ActividadEvidencia mapRow(ResultSet rs, int rowNum) throws SQLException {
        return ActividadEvidencia.builder()
                .nActividadEvidenciaId(rs.getInt("nActividadEvidenciaId"))
                .nActividadId(rs.getInt("nActividadId"))
                .cNombreArchivo(rs.getString("cNombreArchivo"))
                .cRutaArchivo(rs.getString("cRutaArchivo"))
                .cTipoArchivo(rs.getString("cTipoArchivo"))
                .nTamano(rs.getObject("nTamano") != null ? rs.getInt("nTamano") : null)
                .dFechaCreacion(rs.getTimestamp("dFechaCreacion") != null ? rs.getTimestamp("dFechaCreacion").toLocalDateTime() : null)
                .bEstado(rs.getBoolean("bEstado"))
                .build();
    }
}