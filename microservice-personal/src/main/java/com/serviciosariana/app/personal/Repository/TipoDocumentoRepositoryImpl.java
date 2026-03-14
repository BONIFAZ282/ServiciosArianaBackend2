package com.serviciosariana.app.personal.Repository;

import com.serviciosariana.app.personal.Model.TipoDocumento;
import com.serviciosariana.app.personal.Repository.RowMapper.TipoDocumentoRowMapper;
import com.serviciosariana.app.personal.Repository.StoredProcedure.StoredProcedureTipoDocumento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TipoDocumentoRepositoryImpl implements TipoDocumentoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<TipoDocumento> listarTodos() {
        return jdbcTemplate.query(StoredProcedureTipoDocumento.LST_TODOS, new TipoDocumentoRowMapper());
    }
}