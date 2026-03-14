package com.serviciosariana.app.servicio.Repository;

import com.serviciosariana.app.servicio.Model.Actividad;
import com.serviciosariana.app.servicio.Repository.RowMapper.ActividadDetalleRowMapper;
import com.serviciosariana.app.servicio.Repository.RowMapper.ActividadPersonalRowMapper;
import com.serviciosariana.app.servicio.Repository.RowMapper.ActividadRowMapper;
import com.serviciosariana.app.servicio.Repository.StoredProcedure.StoredProcedureActividad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class ActividadRepositoryImpl implements ActividadRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ActividadRowMapper actividadRowMapper;

    @Autowired
    private ActividadDetalleRowMapper actividadDetalleRowMapper;

    @Autowired
    private ActividadPersonalRowMapper actividadPersonalRowMapper;

    @Override
    public Integer insertar(Integer nOrdenServicioId, Integer nPersonalId, String cTitulo,
                            String cDescripcion, LocalDate dFechaActividad) {
        List<Map<String, Object>> result = jdbcTemplate.queryForList(
                StoredProcedureActividad.SP_INSERTAR,
                nOrdenServicioId, nPersonalId, cTitulo, cDescripcion,
                dFechaActividad != null ? Date.valueOf(dFechaActividad) : null
        );

        if (!result.isEmpty()) {
            Number id = (Number) result.get(0).get("nActividadId");
            return id != null ? id.intValue() : null;
        }
        return null;
    }

    @Override
    public Integer actualizar(Integer nActividadId, String cTitulo, String cDescripcion, LocalDate dFechaActividad) {
        List<Map<String, Object>> result = jdbcTemplate.queryForList(
                StoredProcedureActividad.SP_ACTUALIZAR,
                nActividadId, cTitulo, cDescripcion,
                dFechaActividad != null ? Date.valueOf(dFechaActividad) : null
        );

        if (!result.isEmpty()) {
            Number id = (Number) result.get(0).get("nActividadId");
            return id != null ? id.intValue() : null;
        }
        return null;
    }

    @Override
    public void eliminar(Integer nActividadId) {
        jdbcTemplate.queryForList(StoredProcedureActividad.SP_ELIMINAR, nActividadId);
    }

    @Override
    public Optional<Actividad> obtenerPorId(Integer nActividadId) {
        List<Actividad> result = jdbcTemplate.query(
                StoredProcedureActividad.SP_OBTENER_POR_ID,
                actividadDetalleRowMapper,
                nActividadId
        );
        return result.isEmpty() ? Optional.empty() : Optional.of(result.get(0));
    }

    @Override
    public List<Actividad> listarPorOrden(Integer nOrdenServicioId) {
        return jdbcTemplate.query(
                StoredProcedureActividad.SP_LISTAR_POR_ORDEN,
                actividadRowMapper,
                nOrdenServicioId
        );
    }

    @Override
    public List<Actividad> listarPorPersonal(Integer nPersonalId) {
        return jdbcTemplate.query(
                StoredProcedureActividad.SP_LISTAR_POR_PERSONAL,
                actividadPersonalRowMapper,
                nPersonalId
        );
    }
}