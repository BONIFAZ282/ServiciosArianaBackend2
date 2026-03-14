package com.serviciosariana.app.servicio.Services;

import com.serviciosariana.app.servicio.Model.Cliente;
import com.serviciosariana.app.servicio.Model.dto.*;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    List<ClienteListDTO> listarTodos();
    List<ClienteComboDTO> listarCombo();
    List<ClienteListDTO> buscar(String cTextoBusqueda);
    Optional<Cliente> obtenerPorId(Integer nClienteId);
    ExisteDocumentoDTO existeDocumento(Integer nTipoDocumentoId, String cNumeroDocumento);
    ClienteCreatedDTO crear(ClienteRequest request);
    void actualizar(Integer nClienteId, ClienteRequest request);
    void eliminar(Integer nClienteId);
    ClienteBusquedaDTO buscarPorDocumento(String cNumeroDocumento);

}