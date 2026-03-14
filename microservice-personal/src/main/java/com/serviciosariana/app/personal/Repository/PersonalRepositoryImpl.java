    package com.serviciosariana.app.personal.Repository;

    import com.serviciosariana.app.personal.Model.Personal;
    import com.serviciosariana.app.personal.Model.dto.LiderDTO;
    import com.serviciosariana.app.personal.Model.dto.PersonalConLiderDTO;
    import com.serviciosariana.app.personal.Model.dto.PersonalListDTO;
    import com.serviciosariana.app.personal.Repository.RowMapper.LiderRowMapper;
    import com.serviciosariana.app.personal.Repository.RowMapper.PersonalConLiderRowMapper;
    import com.serviciosariana.app.personal.Repository.RowMapper.PersonalListRowMapper;
    import com.serviciosariana.app.personal.Repository.RowMapper.PersonalRowMapper;
    import com.serviciosariana.app.personal.Repository.StoredProcedure.StoredProcedurePersonal;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.jdbc.core.JdbcTemplate;
    import org.springframework.stereotype.Repository;

    import java.math.BigDecimal;
    import java.sql.Date;
    import java.time.LocalDate;
    import java.util.List;
    import java.util.Optional;

    @Repository
    public class PersonalRepositoryImpl implements PersonalRepository {

        @Autowired
        private JdbcTemplate jdbcTemplate;

        @Autowired
        private PersonalConLiderRowMapper personalConLiderRowMapper;


        @Override
        public List<PersonalListDTO> listarTodos() {
            return jdbcTemplate.query(StoredProcedurePersonal.LST_TODOS, new PersonalListRowMapper());
        }

        @Override
        public List<PersonalListDTO> listarPorCargo(Integer nCargoId) {
            return jdbcTemplate.query(StoredProcedurePersonal.LST_POR_CARGO, new Object[]{nCargoId}, new PersonalListRowMapper());
        }

        @Override
        public List<PersonalListDTO> listarPorLider(Integer nPersonalLiderId) {
            return jdbcTemplate.query(StoredProcedurePersonal.LST_POR_LIDER, new Object[]{nPersonalLiderId}, new PersonalListRowMapper());
        }

        @Override
        public List<LiderDTO> listarLideres() {
            return jdbcTemplate.query(StoredProcedurePersonal.LST_LIDERES, new LiderRowMapper());
        }

        @Override
        public Optional<Personal> obtenerPorId(Integer nPersonalId) {
            List<Personal> lista = jdbcTemplate.query(StoredProcedurePersonal.GET_POR_ID, new Object[]{nPersonalId}, new PersonalRowMapper());
            return lista.stream().findFirst();
        }

        @Override
        public Integer insertar(Integer nPersonaId, Integer nCargoId, Integer nPersonalLiderId, LocalDate dFechaIngreso, BigDecimal nSueldo, String cObservaciones) {
            return jdbcTemplate.queryForObject(
                    StoredProcedurePersonal.INS_NUEVO,
                    new Object[]{nPersonaId, nCargoId, nPersonalLiderId, Date.valueOf(dFechaIngreso), nSueldo, cObservaciones},
                    Integer.class
            );
        }

        @Override
        public void actualizar(Integer nPersonalId, Integer nCargoId, Integer nPersonalLiderId, LocalDate dFechaIngreso, LocalDate dFechaCese, BigDecimal nSueldo, String cObservaciones, Boolean bEstado) {
            jdbcTemplate.update(
                    StoredProcedurePersonal.UPD_ACTUALIZAR,
                    nPersonalId, nCargoId, nPersonalLiderId,
                    Date.valueOf(dFechaIngreso),
                    dFechaCese != null ? Date.valueOf(dFechaCese) : null,
                    nSueldo, cObservaciones, bEstado
            );
        }

        @Override
        public void eliminar(Integer nPersonalId) {
            jdbcTemplate.update(StoredProcedurePersonal.DEL_ELIMINAR, nPersonalId);
        }

        @Override
        public List<PersonalConLiderDTO> listarConLider() {
            return jdbcTemplate.query(
                    StoredProcedurePersonal.SP_LISTAR_CON_LIDER,
                    personalConLiderRowMapper
            );
        }
    }