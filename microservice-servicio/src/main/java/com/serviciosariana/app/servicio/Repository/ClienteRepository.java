package com.serviciosariana.app.servicio.Repository;

import com.serviciosariana.app.servicio.Model.Cliente;
import com.serviciosariana.app.servicio.Model.dto.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ClienteRepository {
    List<ClienteListDTO> listarTodos();
    List<ClienteComboDTO> listarCombo();
    List<ClienteListDTO> buscar(String cTextoBusqueda);
    Optional<Cliente> obtenerPorId(Integer nClienteId);
    ExisteDocumentoDTO existeDocumento(Integer nTipoDocumentoId, String cNumeroDocumento);
    ClienteCreatedDTO insertar(Integer nTipoDocumentoId, String cNumeroDocumento, String cNombres,
                               String cApellidoPaterno, String cApellidoMaterno, String cSexo,
                               LocalDate dFechaNacimiento, String cTelefono, String cEmail,
                               String cDireccion, String cRazonSocial, String cNombreComercial,
                               String cObservaciones);
    void actualizar(Integer nClienteId, Integer nTipoDocumentoId, String cNumeroDocumento,
                    String cNombres, String cApellidoPaterno, String cApellidoMaterno,
                    String cSexo, LocalDate dFechaNacimiento, String cTelefono, String cEmail,
                    String cDireccion, String cRazonSocial, String cNombreComercial,
                    String cObservaciones, Boolean bEstado);
    void eliminar(Integer nClienteId);
    ClienteBusquedaDTO buscarPorDocumento(String cNumeroDocumento);

}