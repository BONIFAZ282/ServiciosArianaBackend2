package com.serviciosariana.app.servicio.Repository;

import com.serviciosariana.app.servicio.Model.Cliente;
import com.serviciosariana.app.servicio.Model.dto.*;
import com.serviciosariana.app.servicio.Repository.RowMapper.ClienteBusquedaRowMapper;
import com.serviciosariana.app.servicio.Repository.RowMapper.ClienteComboRowMapper;
import com.serviciosariana.app.servicio.Repository.RowMapper.ClienteListRowMapper;
import com.serviciosariana.app.servicio.Repository.RowMapper.ClienteRowMapper;
import com.serviciosariana.app.servicio.Repository.StoredProcedure.StoredProcedureCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class ClienteRepositoryImpl implements ClienteRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ClienteBusquedaRowMapper clienteBusquedaRowMapper;

    @Override
    public List<ClienteListDTO> listarTodos() {
        return jdbcTemplate.query(StoredProcedureCliente.LST_TODOS, new ClienteListRowMapper());
    }

    @Override
    public List<ClienteComboDTO> listarCombo() {
        return jdbcTemplate.query(StoredProcedureCliente.LST_COMBO, new ClienteComboRowMapper());
    }

    @Override
    public List<ClienteListDTO> buscar(String cTextoBusqueda) {
        return jdbcTemplate.query(StoredProcedureCliente.LST_BUSCAR, new Object[]{cTextoBusqueda}, new ClienteListRowMapper());
    }

    @Override
    public Optional<Cliente> obtenerPorId(Integer nClienteId) {
        List<Cliente> lista = jdbcTemplate.query(StoredProcedureCliente.GET_POR_ID, new Object[]{nClienteId}, new ClienteRowMapper());
        return lista.stream().findFirst();
    }

    @Override
    public ExisteDocumentoDTO existeDocumento(Integer nTipoDocumentoId, String cNumeroDocumento) {
        return jdbcTemplate.queryForObject(
                StoredProcedureCliente.GET_EXISTE_DOCUMENTO,
                new Object[]{nTipoDocumentoId, cNumeroDocumento},
                (rs, rowNum) -> ExisteDocumentoDTO.builder()
                        .bExiste(rs.getBoolean("bExiste"))
                        .cMensaje(rs.getString("cMensaje"))
                        .build()
        );
    }

    @Override
    public ClienteCreatedDTO insertar(Integer nTipoDocumentoId, String cNumeroDocumento, String cNombres,
                                      String cApellidoPaterno, String cApellidoMaterno, String cSexo,
                                      LocalDate dFechaNacimiento, String cTelefono, String cEmail,
                                      String cDireccion, String cRazonSocial, String cNombreComercial,
                                      String cObservaciones) {
        return jdbcTemplate.queryForObject(
                StoredProcedureCliente.INS_NUEVO,
                new Object[]{
                        nTipoDocumentoId, cNumeroDocumento, cNombres, cApellidoPaterno, cApellidoMaterno,
                        cSexo, dFechaNacimiento != null ? Date.valueOf(dFechaNacimiento) : null,
                        cTelefono, cEmail, cDireccion, cRazonSocial, cNombreComercial, cObservaciones
                },
                (rs, rowNum) -> ClienteCreatedDTO.builder()
                        .nClienteId(rs.getInt("nClienteId"))
                        .cClienteCod(rs.getString("cClienteCod"))
                        .build()
        );
    }

    @Override
    public void actualizar(Integer nClienteId, Integer nTipoDocumentoId, String cNumeroDocumento,
                           String cNombres, String cApellidoPaterno, String cApellidoMaterno,
                           String cSexo, LocalDate dFechaNacimiento, String cTelefono, String cEmail,
                           String cDireccion, String cRazonSocial, String cNombreComercial,
                           String cObservaciones, Boolean bEstado) {
        jdbcTemplate.query(
                StoredProcedureCliente.UPD_ACTUALIZAR,
                new Object[]{
                        nClienteId, nTipoDocumentoId, cNumeroDocumento, cNombres, cApellidoPaterno,
                        cApellidoMaterno, cSexo, dFechaNacimiento != null ? Date.valueOf(dFechaNacimiento) : null,
                        cTelefono, cEmail, cDireccion, cRazonSocial, cNombreComercial, cObservaciones, bEstado
                },
                rs -> null
        );
    }

    @Override
    public void eliminar(Integer nClienteId) {
        jdbcTemplate.query(StoredProcedureCliente.DEL_ELIMINAR, new Object[]{nClienteId}, rs -> null);
    }

    @Override
    public ClienteBusquedaDTO buscarPorDocumento(String cNumeroDocumento) {
        List<ClienteBusquedaDTO> result = jdbcTemplate.query(
                StoredProcedureCliente.SP_BUSCAR_POR_DOCUMENTO,
                clienteBusquedaRowMapper,
                cNumeroDocumento
        );
        return result.isEmpty() ? null : result.get(0);
    }
}