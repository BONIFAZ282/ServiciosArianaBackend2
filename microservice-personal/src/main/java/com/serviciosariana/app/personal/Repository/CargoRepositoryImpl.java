package com.serviciosariana.app.personal.Repository;

import com.serviciosariana.app.personal.Model.Cargo;
import com.serviciosariana.app.personal.Repository.RowMapper.CargoRowMapper;
import com.serviciosariana.app.personal.Repository.StoredProcedure.StoredProcedureCargo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CargoRepositoryImpl implements CargoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Cargo> listarTodos() {
        return jdbcTemplate.query(StoredProcedureCargo.LST_TODOS, new CargoRowMapper());
    }

    @Override
    public Optional<Cargo> obtenerPorId(Integer nCargoId) {
        List<Cargo> lista = jdbcTemplate.query(StoredProcedureCargo.GET_POR_ID, new Object[]{nCargoId}, new CargoRowMapper());
        return lista.stream().findFirst();
    }

    @Override
    public Integer insertar(String cCargoCod, String cNombre, String cDescripcion) {
        return jdbcTemplate.queryForObject(StoredProcedureCargo.INS_NUEVO, new Object[]{cCargoCod, cNombre, cDescripcion}, Integer.class);
    }

    @Override
    public void actualizar(Integer nCargoId, String cCargoCod, String cNombre, String cDescripcion, Boolean bEstado) {
        jdbcTemplate.update(StoredProcedureCargo.UPD_ACTUALIZAR, nCargoId, cCargoCod, cNombre, cDescripcion, bEstado);
    }

    @Override
    public void eliminar(Integer nCargoId) {
        jdbcTemplate.update(StoredProcedureCargo.DEL_ELIMINAR, nCargoId);
    }
}