package com.serviciosariana.app.servicio.Repository;

import com.serviciosariana.app.servicio.Model.OrdenServicio;
import com.serviciosariana.app.servicio.Model.OrdenServicioHistorial;
import com.serviciosariana.app.servicio.Model.dto.EquipoLiderDTO;
import com.serviciosariana.app.servicio.Model.dto.OrdenResumenLiderDTO;
import com.serviciosariana.app.servicio.Model.dto.OrdenServicioCreatedDTO;
import com.serviciosariana.app.servicio.Repository.RowMapper.*;
import com.serviciosariana.app.servicio.Repository.StoredProcedure.StoredProcedureOrdenServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class OrdenServicioRepositoryImpl implements OrdenServicioRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private OrdenServicioRowMapper ordenServicioRowMapper;

    @Autowired
    private OrdenServicioDetalleRowMapper ordenServicioDetalleRowMapper;

    @Autowired
    private OrdenServicioHistorialRowMapper ordenServicioHistorialRowMapper;

    @Autowired
    private EquipoLiderRowMapper equipoLiderRowMapper;

    @Autowired
    private OrdenResumenLiderRowMapper ordenResumenLiderRowMapper;

    @Override
    public OrdenServicioCreatedDTO insertar(Integer nClienteId, Integer nTipoServicioId, Integer nPrioridadId,
                                            String cTitulo, String cDescripcion, LocalDate dFechaInicio,
                                            LocalDate dFechaFin, Integer nPersonalLiderId, String cDireccionServicio,
                                            BigDecimal nCostoEstimado, String cObservaciones, Integer nUsuarioCreacionId) {

        List<Map<String, Object>> result = jdbcTemplate.queryForList(
                StoredProcedureOrdenServicio.SP_INSERTAR,
                nClienteId, nTipoServicioId, nPrioridadId, cTitulo, cDescripcion,
                dFechaInicio != null ? Date.valueOf(dFechaInicio) : null,
                dFechaFin != null ? Date.valueOf(dFechaFin) : null,
                nPersonalLiderId, cDireccionServicio, nCostoEstimado, cObservaciones, nUsuarioCreacionId
        );

        if (!result.isEmpty()) {
            Map<String, Object> row = result.get(0);
            return OrdenServicioCreatedDTO.builder()
                    .nOrdenServicioId((Integer) row.get("nOrdenServicioId"))
                    .cOrdenServicioCod((String) row.get("cOrdenServicioCod"))
                    .build();
        }
        return null;
    }

    @Override
    public Integer actualizar(Integer nOrdenServicioId, Integer nClienteId, Integer nTipoServicioId,
                              Integer nPrioridadId, String cTitulo, String cDescripcion, LocalDate dFechaInicio,
                              LocalDate dFechaFin, Integer nPersonalLiderId, String cDireccionServicio,
                              BigDecimal nCostoEstimado, BigDecimal nCostoReal, String cObservaciones) {

        List<Map<String, Object>> result = jdbcTemplate.queryForList(
                StoredProcedureOrdenServicio.SP_ACTUALIZAR,
                nOrdenServicioId, nClienteId, nTipoServicioId, nPrioridadId, cTitulo, cDescripcion,
                dFechaInicio != null ? Date.valueOf(dFechaInicio) : null,
                dFechaFin != null ? Date.valueOf(dFechaFin) : null,
                nPersonalLiderId, cDireccionServicio, nCostoEstimado, nCostoReal, cObservaciones
        );

        if (!result.isEmpty()) {
            return (Integer) result.get(0).get("nOrdenServicioId");
        }
        return null;
    }

    @Override
    public void cambiarEstado(Integer nOrdenServicioId, String cEstadoOrdenCodNuevo, String cComentario, Integer nUsuarioId) {
        jdbcTemplate.queryForList(
                StoredProcedureOrdenServicio.SP_CAMBIAR_ESTADO,
                nOrdenServicioId, cEstadoOrdenCodNuevo, cComentario, nUsuarioId
        );
    }

    @Override
    public void eliminar(Integer nOrdenServicioId) {
        jdbcTemplate.queryForList(StoredProcedureOrdenServicio.SP_ELIMINAR, nOrdenServicioId);
    }

    @Override
    public Optional<OrdenServicio> obtenerPorId(Integer nOrdenServicioId) {
        List<OrdenServicio> result = jdbcTemplate.query(
                StoredProcedureOrdenServicio.SP_OBTENER_POR_ID,
                ordenServicioDetalleRowMapper,
                nOrdenServicioId
        );
        return result.isEmpty() ? Optional.empty() : Optional.of(result.get(0));
    }

    @Override
    public List<OrdenServicio> listarTodos() {
        return jdbcTemplate.query(StoredProcedureOrdenServicio.SP_LISTAR_TODOS, ordenServicioRowMapper);
    }

    @Override
    public List<OrdenServicioHistorial> listarHistorial(Integer nOrdenServicioId) {
        return jdbcTemplate.query(
                StoredProcedureOrdenServicio.SP_LISTAR_HISTORIAL,
                ordenServicioHistorialRowMapper,
                nOrdenServicioId
        );
    }

    @Override
    public List<EquipoLiderDTO> listarEquipoPorLider(Integer nPersonalLiderId) {
        return jdbcTemplate.query(
                StoredProcedureOrdenServicio.SP_EQUIPO_POR_LIDER,
                equipoLiderRowMapper,
                nPersonalLiderId
        );
    }

    @Override
    public List<OrdenResumenLiderDTO> listarResumenPorLider(Integer nPersonalLiderId) {
        return jdbcTemplate.query(
                StoredProcedureOrdenServicio.SP_RESUMEN_POR_LIDER,
                ordenResumenLiderRowMapper,
                nPersonalLiderId
        );
    }
}