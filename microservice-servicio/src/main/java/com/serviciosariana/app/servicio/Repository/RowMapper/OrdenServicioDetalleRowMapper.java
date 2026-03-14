package com.serviciosariana.app.servicio.Repository.RowMapper;

import com.serviciosariana.app.servicio.Model.OrdenServicio;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class OrdenServicioDetalleRowMapper implements RowMapper<OrdenServicio> {

    @Override
    public OrdenServicio mapRow(ResultSet rs, int rowNum) throws SQLException {
        return OrdenServicio.builder()
                .nOrdenServicioId(rs.getInt("nOrdenServicioId"))
                .cOrdenServicioCod(rs.getString("cOrdenServicioCod"))
                .nClienteId(rs.getInt("nClienteId"))
                .cClienteCod(rs.getString("cClienteCod"))
                .cClienteNombre(rs.getString("cClienteNombre"))
                .cClienteDocumento(rs.getString("cClienteDocumento"))
                .cClienteTelefono(rs.getString("cClienteTelefono"))
                .cClienteEmail(rs.getString("cClienteEmail"))
                .nTipoServicioId(rs.getInt("nTipoServicioId"))
                .cTipoServicioCod(rs.getString("cTipoServicioCod"))
                .cTipoServicioNombre(rs.getString("cTipoServicioNombre"))
                .nPrioridadId(rs.getInt("nPrioridadId"))
                .cPrioridadCod(rs.getString("cPrioridadCod"))
                .cPrioridadNombre(rs.getString("cPrioridadNombre"))
                .cPrioridadColor(rs.getString("cPrioridadColor"))
                .nEstadoOrdenId(rs.getInt("nEstadoOrdenId"))
                .cEstadoOrdenCod(rs.getString("cEstadoOrdenCod"))
                .cEstadoOrdenNombre(rs.getString("cEstadoOrdenNombre"))
                .cEstadoOrdenColor(rs.getString("cEstadoOrdenColor"))
                .bPermiteEditar(rs.getBoolean("bPermiteEditar"))
                .cTitulo(rs.getString("cTitulo"))
                .cDescripcion(rs.getString("cDescripcion"))
                .dFechaInicio(rs.getDate("dFechaInicio") != null ? rs.getDate("dFechaInicio").toLocalDate() : null)
                .dFechaFin(rs.getDate("dFechaFin") != null ? rs.getDate("dFechaFin").toLocalDate() : null)
                .dFechaFinReal(rs.getDate("dFechaFinReal") != null ? rs.getDate("dFechaFinReal").toLocalDate() : null)
                .nPersonalLiderId(rs.getObject("nPersonalLiderId") != null ? rs.getInt("nPersonalLiderId") : null)
                .cPersonalLiderNombre(rs.getString("cPersonalLiderNombre"))
                .cDireccionServicio(rs.getString("cDireccionServicio"))
                .nCostoEstimado(rs.getBigDecimal("nCostoEstimado"))
                .nCostoReal(rs.getBigDecimal("nCostoReal"))
                .cObservaciones(rs.getString("cObservaciones"))
                .dFechaCreacion(rs.getTimestamp("dFechaCreacion") != null ? rs.getTimestamp("dFechaCreacion").toLocalDateTime() : null)
                .nUsuarioCreacionId(rs.getObject("nUsuarioCreacionId") != null ? rs.getInt("nUsuarioCreacionId") : null)
                .bEstado(rs.getBoolean("bEstado"))
                .build();
    }
}