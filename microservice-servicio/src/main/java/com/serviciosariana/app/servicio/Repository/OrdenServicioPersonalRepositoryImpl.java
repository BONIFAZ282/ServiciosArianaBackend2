package com.serviciosariana.app.servicio.Repository;

import com.serviciosariana.app.servicio.Model.OrdenServicioPersonal;
import com.serviciosariana.app.servicio.Model.dto.PersonalDisponibleDTO;
import com.serviciosariana.app.servicio.Repository.RowMapper.OrdenServicioPersonalRowMapper;
import com.serviciosariana.app.servicio.Repository.RowMapper.PersonalDisponibleRowMapper;
import com.serviciosariana.app.servicio.Repository.StoredProcedure.StoredProcedureOrdenServicioPersonal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class OrdenServicioPersonalRepositoryImpl implements OrdenServicioPersonalRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private OrdenServicioPersonalRowMapper ordenServicioPersonalRowMapper;

    @Autowired
    private PersonalDisponibleRowMapper personalDisponibleRowMapper;

    @Override
    public Integer asignar(Integer nOrdenServicioId, Integer nPersonalId, String cObservaciones) {
        List<Map<String, Object>> result = jdbcTemplate.queryForList(
                StoredProcedureOrdenServicioPersonal.SP_ASIGNAR,
                nOrdenServicioId, nPersonalId, cObservaciones
        );

        if (!result.isEmpty()) {
            return ((Number) result.get(0).get("nOrdenServicioPersonalId")).intValue();
        }
        return null;
    }

    @Override
    public void desasignar(Integer nOrdenServicioId, Integer nPersonalId) {
        jdbcTemplate.queryForList(
                StoredProcedureOrdenServicioPersonal.SP_DESASIGNAR,
                nOrdenServicioId, nPersonalId
        );
    }

    @Override
    public List<OrdenServicioPersonal> listarPorOrden(Integer nOrdenServicioId) {
        return jdbcTemplate.query(
                StoredProcedureOrdenServicioPersonal.SP_LISTAR_POR_ORDEN,
                ordenServicioPersonalRowMapper,
                nOrdenServicioId
        );
    }

    @Override
    public List<PersonalDisponibleDTO> listarDisponibles(Integer nOrdenServicioId) {
        return jdbcTemplate.query(
                StoredProcedureOrdenServicioPersonal.SP_LISTAR_DISPONIBLES,
                personalDisponibleRowMapper,
                nOrdenServicioId
        );
    }
}