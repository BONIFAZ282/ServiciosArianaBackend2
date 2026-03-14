package com.serviciosariana.app.servicio.Repository;

import com.serviciosariana.app.servicio.Model.dto.*;
import com.serviciosariana.app.servicio.Repository.RowMapper.*;
import com.serviciosariana.app.servicio.Repository.StoredProcedure.StoredProcedureReporteDashboard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReporteDashboardRepositoryImpl implements ReporteDashboardRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ResumenDashboardRowMapper resumenDashboardRowMapper;

    @Autowired
    private EstadoReporteRowMapper estadoReporteRowMapper;

    @Autowired
    private PrioridadReporteRowMapper prioridadReporteRowMapper;

    @Autowired
    private MesReporteRowMapper mesReporteRowMapper;

    @Autowired
    private TopClienteRowMapper topClienteRowMapper;

    @Autowired
    private TopServicioRowMapper topServicioRowMapper;

    @Autowired
    private OrdenVencidaRowMapper ordenVencidaRowMapper;

    @Override
    public ResumenDashboardDTO obtenerResumen() {
        List<ResumenDashboardDTO> result = jdbcTemplate.query(
                StoredProcedureReporteDashboard.SP_RESUMEN,
                resumenDashboardRowMapper
        );
        return result.isEmpty() ? null : result.get(0);
    }

    @Override
    public List<EstadoReporteDTO> listarPorEstado() {
        return jdbcTemplate.query(
                StoredProcedureReporteDashboard.SP_POR_ESTADO,
                estadoReporteRowMapper
        );
    }

    @Override
    public List<PrioridadReporteDTO> listarPorPrioridad() {
        return jdbcTemplate.query(
                StoredProcedureReporteDashboard.SP_POR_PRIORIDAD,
                prioridadReporteRowMapper
        );
    }

    @Override
    public List<MesReporteDTO> listarPorMes() {
        return jdbcTemplate.query(
                StoredProcedureReporteDashboard.SP_POR_MES,
                mesReporteRowMapper
        );
    }

    @Override
    public List<TopClienteDTO> listarTopClientes() {
        return jdbcTemplate.query(
                StoredProcedureReporteDashboard.SP_TOP_CLIENTES,
                topClienteRowMapper
        );
    }

    @Override
    public List<TopServicioDTO> listarTopServicios() {
        return jdbcTemplate.query(
                StoredProcedureReporteDashboard.SP_TOP_SERVICIOS,
                topServicioRowMapper
        );
    }

    @Override
    public List<OrdenVencidaDTO> listarOrdenesVencidas() {
        return jdbcTemplate.query(
                StoredProcedureReporteDashboard.SP_ORDENES_VENCIDAS,
                ordenVencidaRowMapper
        );
    }
}