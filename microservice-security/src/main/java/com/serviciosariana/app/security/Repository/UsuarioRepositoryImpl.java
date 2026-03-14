package com.serviciosariana.app.security.Repository;

import com.serviciosariana.app.security.Model.Usuario;
import com.serviciosariana.app.security.Model.dto.BloqueoResponse;
import com.serviciosariana.app.security.Model.dto.IntentoFallidoResponse;
import com.serviciosariana.app.security.Model.dto.UsuarioListDTO;
import com.serviciosariana.app.security.Repository.RowMapper.UsuarioListRowMapper;
import com.serviciosariana.app.security.Repository.RowMapper.UsuarioRowMapper;
import com.serviciosariana.app.security.Repository.StoredProcedure.StoredProcedureUsuario;
import com.serviciosariana.app.security.Repository.Translator.UsuarioTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<UsuarioListDTO> listarTodos() {
        String sql = StoredProcedureUsuario.LST_TODOS;
        return jdbcTemplate.query(sql, new UsuarioListRowMapper());
    }

    @Override
    public Optional<Usuario> obtenerPorId(Integer nUsuarioId) {
        String sql = StoredProcedureUsuario.GET_POR_ID;
        List<UsuarioTranslator> lista = jdbcTemplate.query(sql, new Object[]{nUsuarioId}, new UsuarioRowMapper());
        return lista.stream()
                .map(UsuarioTranslator::toUsuario)
                .findFirst();
    }

    @Override
    public Optional<Usuario> obtenerPorUsuario(String cUsuario) {
        String sql = StoredProcedureUsuario.GET_POR_USUARIO;
        List<UsuarioTranslator> lista = jdbcTemplate.query(sql, new Object[]{cUsuario}, new UsuarioRowMapper());
        return lista.stream()
                .map(UsuarioTranslator::toUsuario)
                .findFirst();
    }

    @Override
    public BloqueoResponse verificarBloqueo(String cUsuario) {
        String sql = StoredProcedureUsuario.GET_ESTA_BLOQUEADO;
        return jdbcTemplate.queryForObject(sql, new Object[]{cUsuario}, (rs, rowNum) ->
                BloqueoResponse.builder()
                        .bBloqueado(rs.getBoolean("bBloqueado"))
                        .cMensaje(rs.getString("cMensaje"))
                        .dFechaDesbloqueo(toLocalDateTime(rs.getTimestamp("dFechaDesbloqueo")))
                        .build()
        );
    }

    @Override
    public Integer insertar(Integer nPersonalId, String cUsuario, String cPassword) {
        String sql = StoredProcedureUsuario.INS_NUEVO;
        return jdbcTemplate.queryForObject(sql, new Object[]{nPersonalId, cUsuario, cPassword}, Integer.class);
    }

    @Override
    public void actualizarPassword(Integer nUsuarioId, String cPassword) {
        String sql = StoredProcedureUsuario.UPD_PASSWORD;
        jdbcTemplate.update(sql, nUsuarioId, cPassword);
    }

    @Override
    public void actualizarEstado(Integer nUsuarioId, Boolean bEstado) {
        String sql = StoredProcedureUsuario.UPD_ESTADO;
        jdbcTemplate.update(sql, nUsuarioId, bEstado);
    }

    @Override
    public void desbloquear(Integer nUsuarioId) {
        String sql = StoredProcedureUsuario.UPD_DESBLOQUEAR;
        jdbcTemplate.update(sql, nUsuarioId);
    }


    @Override
    public IntentoFallidoResponse registrarIntentoFallido(String cUsuario) {
        String sql = StoredProcedureUsuario.UPD_INTENTO_FALLIDO;
        return jdbcTemplate.queryForObject(sql, new Object[]{cUsuario}, (rs, rowNum) ->
                IntentoFallidoResponse.builder()
                        .bBloqueado(rs.getBoolean("bBloqueado"))
                        .nMinutosBloqueo(rs.getInt("nMinutosBloqueo"))
                        .nIntentosRestantes(rs.getInt("nIntentosRestantes"))
                        .build()
        );
    }

    @Override
    public void actualizarUltimoAcceso(Integer nUsuarioId) {
        String sql = StoredProcedureUsuario.UPD_ULTIMO_ACCESO;
        jdbcTemplate.update(sql, nUsuarioId);
    }

    private java.time.LocalDateTime toLocalDateTime(Timestamp timestamp) {
        return timestamp != null ? timestamp.toLocalDateTime() : null;
    }
}