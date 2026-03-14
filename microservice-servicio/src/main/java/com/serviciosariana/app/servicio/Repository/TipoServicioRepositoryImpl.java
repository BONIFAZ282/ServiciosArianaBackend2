package com.serviciosariana.app.servicio.Repository;

import com.serviciosariana.app.servicio.Model.TipoServicio;
import com.serviciosariana.app.servicio.Model.dto.TipoServicioComboDTO;
import com.serviciosariana.app.servicio.Repository.RowMapper.TipoServicioComboRowMapper;
import com.serviciosariana.app.servicio.Repository.RowMapper.TipoServicioRowMapper;
import com.serviciosariana.app.servicio.Repository.StoredProcedure.StoredProcedureTipoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class TipoServicioRepositoryImpl implements TipoServicioRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private TipoServicioComboRowMapper tipoServicioComboRowMapper;


    @Override
    public List<TipoServicio> listarTodos() {
        return jdbcTemplate.query(StoredProcedureTipoServicio.LST_TODOS, new TipoServicioRowMapper());
    }

    @Override
    public Integer insertar(String cTipoServicioCod, String cNombre, String cDescripcion, BigDecimal nPrecioBase) {
        return jdbcTemplate.queryForObject(
                StoredProcedureTipoServicio.INS_NUEVO,
                new Object[]{cTipoServicioCod, cNombre, cDescripcion, nPrecioBase},
                Integer.class
        );
    }

    @Override
    public void actualizar(Integer nTipoServicioId, String cTipoServicioCod, String cNombre, String cDescripcion, BigDecimal nPrecioBase, Boolean bEstado) {
        jdbcTemplate.query(
                StoredProcedureTipoServicio.UPD_ACTUALIZAR,
                new Object[]{nTipoServicioId, cTipoServicioCod, cNombre, cDescripcion, nPrecioBase, bEstado},
                rs -> null
        );
    }

    @Override
    public void eliminar(Integer nTipoServicioId) {
        jdbcTemplate.query(StoredProcedureTipoServicio.DEL_ELIMINAR, new Object[]{nTipoServicioId}, rs -> null);
    }

    @Override
    public List<TipoServicioComboDTO> listarParaCombo() {
        return jdbcTemplate.query(
                StoredProcedureTipoServicio.SP_LISTAR_COMBO,
                tipoServicioComboRowMapper
        );
    }
}