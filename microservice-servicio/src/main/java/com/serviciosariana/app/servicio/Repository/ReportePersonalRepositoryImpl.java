package com.serviciosariana.app.servicio.Repository;

import com.serviciosariana.app.servicio.Model.dto.*;
import com.serviciosariana.app.servicio.Repository.RowMapper.*;
import com.serviciosariana.app.servicio.Repository.StoredProcedure.StoredProcedureReportePersonal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReportePersonalRepositoryImpl implements ReportePersonalRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ResumenPersonalRowMapper resumenPersonalRowMapper;

    @Autowired
    private RankingPersonalRowMapper rankingPersonalRowMapper;

    @Autowired
    private CargaTrabajoRowMapper cargaTrabajoRowMapper;

    @Autowired
    private OrdenPersonalRowMapper ordenPersonalRowMapper;

    @Override
    public ResumenPersonalDTO obtenerResumen(Integer nPersonalId) {
        List<ResumenPersonalDTO> result = jdbcTemplate.query(
                StoredProcedureReportePersonal.SP_RESUMEN,
                resumenPersonalRowMapper,
                nPersonalId
        );
        return result.isEmpty() ? null : result.get(0);
    }

    @Override
    public List<RankingPersonalDTO> listarRanking() {
        return jdbcTemplate.query(
                StoredProcedureReportePersonal.SP_RANKING,
                rankingPersonalRowMapper
        );
    }

    @Override
    public List<CargaTrabajoDTO> listarCargaTrabajo() {
        return jdbcTemplate.query(
                StoredProcedureReportePersonal.SP_CARGA_TRABAJO,
                cargaTrabajoRowMapper
        );
    }

    @Override
    public List<OrdenPersonalDTO> listarOrdenes(Integer nPersonalId) {
        return jdbcTemplate.query(
                StoredProcedureReportePersonal.SP_ORDENES,
                ordenPersonalRowMapper,
                nPersonalId
        );
    }
}