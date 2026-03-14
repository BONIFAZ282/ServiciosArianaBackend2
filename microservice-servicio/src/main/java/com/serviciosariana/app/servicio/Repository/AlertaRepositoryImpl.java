package com.serviciosariana.app.servicio.Repository;

import com.serviciosariana.app.servicio.Model.dto.AlertaDTO;
import com.serviciosariana.app.servicio.Model.dto.AlertaNotificacionDTO;
import com.serviciosariana.app.servicio.Model.dto.ContadorAlertasDTO;
import com.serviciosariana.app.servicio.Repository.RowMapper.AlertaNotificacionRowMapper;
import com.serviciosariana.app.servicio.Repository.RowMapper.AlertaRowMapper;
import com.serviciosariana.app.servicio.Repository.RowMapper.ContadorAlertasRowMapper;
import com.serviciosariana.app.servicio.Repository.StoredProcedure.StoredProcedureAlerta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class AlertaRepositoryImpl implements AlertaRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private AlertaRowMapper alertaRowMapper;

    @Autowired
    private ContadorAlertasRowMapper contadorAlertasRowMapper;

    @Autowired
    private AlertaNotificacionRowMapper alertaNotificacionRowMapper;


    @Override
    public Integer generarAutomaticas() {
        List<Map<String, Object>> result = jdbcTemplate.queryForList(StoredProcedureAlerta.SP_GENERAR_AUTOMATICAS);
        if (!result.isEmpty()) {
            Number n = (Number) result.get(0).get("nAlertasGeneradas");
            return n != null ? n.intValue() : 0;
        }
        return 0;
    }

    @Override
    public List<AlertaDTO> listarTodos(Integer nPersonalId, Boolean bSoloNoLeidas) {
        return jdbcTemplate.query(
                StoredProcedureAlerta.SP_LISTAR_TODOS,
                alertaRowMapper,
                nPersonalId, bSoloNoLeidas != null && bSoloNoLeidas ? 1 : 0
        );
    }

    @Override
    public ContadorAlertasDTO contadorNoLeidas(Integer nPersonalId) {
        List<ContadorAlertasDTO> result = jdbcTemplate.query(
                StoredProcedureAlerta.SP_CONTADOR_NO_LEIDAS,
                contadorAlertasRowMapper,
                nPersonalId
        );
        return result.isEmpty() ? ContadorAlertasDTO.builder().nTotalNoLeidas(0).nPorVencer(0).nVencidas(0).build() : result.get(0);
    }

    @Override
    public void marcarLeida(Integer nAlertaId, Integer nUsuarioId) {
        jdbcTemplate.queryForList(StoredProcedureAlerta.SP_MARCAR_LEIDA, nAlertaId, nUsuarioId);
    }

    @Override
    public Integer marcarTodasLeidas(Integer nPersonalId, Integer nUsuarioId) {
        List<Map<String, Object>> result = jdbcTemplate.queryForList(
                StoredProcedureAlerta.SP_MARCAR_TODAS_LEIDAS,
                nPersonalId, nUsuarioId
        );
        if (!result.isEmpty()) {
            Number n = (Number) result.get(0).get("nAlertasMarcadas");
            return n != null ? n.intValue() : 0;
        }
        return 0;
    }

    @Override
    public Optional<AlertaDTO> obtenerPorId(Integer nAlertaId) {
        List<AlertaDTO> result = jdbcTemplate.query(
                StoredProcedureAlerta.SP_OBTENER_POR_ID,
                alertaRowMapper,
                nAlertaId
        );
        return result.isEmpty() ? Optional.empty() : Optional.of(result.get(0));
    }

    @Override
    public void marcarResuelta(Integer nAlertaId, Integer nUsuarioId) {
        jdbcTemplate.queryForList(StoredProcedureAlerta.SP_MARCAR_RESUELTA, nAlertaId, nUsuarioId);
    }

    @Override
    public List<AlertaNotificacionDTO> listarPendientesNotificacion() {
        return jdbcTemplate.query(
                StoredProcedureAlerta.SP_PENDIENTES_NOTIFICACION,
                alertaNotificacionRowMapper
        );
    }

    @Override
    public void marcarNotificada(Integer nAlertaId) {
        jdbcTemplate.update(StoredProcedureAlerta.SP_MARCAR_NOTIFICADA, nAlertaId);
    }
}