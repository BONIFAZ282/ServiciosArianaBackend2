package com.serviciosariana.app.servicio.Repository;

import com.serviciosariana.app.servicio.Model.EstadoOrden;
import com.serviciosariana.app.servicio.Model.Prioridad;
import com.serviciosariana.app.servicio.Model.TipoAlerta;
import com.serviciosariana.app.servicio.Model.dto.EstadoOrdenSimpleDTO;
import com.serviciosariana.app.servicio.Repository.RowMapper.EstadoOrdenRowMapper;
import com.serviciosariana.app.servicio.Repository.RowMapper.EstadoOrdenSimpleRowMapper;
import com.serviciosariana.app.servicio.Repository.RowMapper.PrioridadRowMapper;
import com.serviciosariana.app.servicio.Repository.RowMapper.TipoAlertaRowMapper;
import com.serviciosariana.app.servicio.Repository.StoredProcedure.StoredProcedureCatalogo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CatalogoRepositoryImpl implements CatalogoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Prioridad> listarPrioridades() {
        return jdbcTemplate.query(StoredProcedureCatalogo.PRIORIDAD_LST_TODOS, new PrioridadRowMapper());
    }

    @Override
    public List<EstadoOrden> listarEstadosOrden() {
        return jdbcTemplate.query(StoredProcedureCatalogo.ESTADO_ORDEN_LST_TODOS, new EstadoOrdenRowMapper());
    }

    @Override
    public List<EstadoOrdenSimpleDTO> listarEstadosSiguientes(String cEstadoOrdenCodActual) {
        return jdbcTemplate.query(
                StoredProcedureCatalogo.ESTADO_ORDEN_LST_SIGUIENTES,
                new Object[]{cEstadoOrdenCodActual},
                new EstadoOrdenSimpleRowMapper()
        );
    }

    @Override
    public List<TipoAlerta> listarTiposAlerta() {
        return jdbcTemplate.query(StoredProcedureCatalogo.TIPO_ALERTA_LST_TODOS, new TipoAlertaRowMapper());
    }
}