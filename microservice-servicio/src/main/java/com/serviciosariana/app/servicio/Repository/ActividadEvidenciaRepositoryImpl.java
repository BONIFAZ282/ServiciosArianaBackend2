package com.serviciosariana.app.servicio.Repository;

import com.serviciosariana.app.servicio.Model.ActividadEvidencia;
import com.serviciosariana.app.servicio.Repository.RowMapper.ActividadEvidenciaRowMapper;
import com.serviciosariana.app.servicio.Repository.StoredProcedure.StoredProcedureActividadEvidencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class ActividadEvidenciaRepositoryImpl implements ActividadEvidenciaRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ActividadEvidenciaRowMapper actividadEvidenciaRowMapper;

    @Override
    public Integer insertar(Integer nActividadId, String cNombreArchivo, String cRutaArchivo,
                            String cTipoArchivo, Integer nTamano) {
        List<Map<String, Object>> result = jdbcTemplate.queryForList(
                StoredProcedureActividadEvidencia.SP_INSERTAR,
                nActividadId, cNombreArchivo, cRutaArchivo, cTipoArchivo, nTamano
        );

        if (!result.isEmpty()) {
            Number id = (Number) result.get(0).get("nActividadEvidenciaId");
            return id != null ? id.intValue() : null;
        }
        return null;
    }

    @Override
    public void eliminar(Integer nActividadEvidenciaId) {
        jdbcTemplate.queryForList(StoredProcedureActividadEvidencia.SP_ELIMINAR, nActividadEvidenciaId);
    }

    @Override
    public List<ActividadEvidencia> listarPorActividad(Integer nActividadId) {
        return jdbcTemplate.query(
                StoredProcedureActividadEvidencia.SP_LISTAR_POR_ACTIVIDAD,
                actividadEvidenciaRowMapper,
                nActividadId
        );
    }

    @Override
    public Optional<ActividadEvidencia> obtenerPorId(Integer nActividadEvidenciaId) {
        List<ActividadEvidencia> result = jdbcTemplate.query(
                StoredProcedureActividadEvidencia.SP_OBTENER_POR_ID,
                actividadEvidenciaRowMapper,
                nActividadEvidenciaId
        );
        return result.isEmpty() ? Optional.empty() : Optional.of(result.get(0));
    }
}