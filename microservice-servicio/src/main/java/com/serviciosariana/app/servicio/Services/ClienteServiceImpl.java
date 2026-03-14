package com.serviciosariana.app.servicio.Services;

import com.serviciosariana.app.servicio.Model.Cliente;
import com.serviciosariana.app.servicio.Model.dto.*;
import com.serviciosariana.app.servicio.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<ClienteListDTO> listarTodos() {
        return clienteRepository.listarTodos();
    }

    @Override
    public List<ClienteComboDTO> listarCombo() {
        return clienteRepository.listarCombo();
    }

    @Override
    public List<ClienteListDTO> buscar(String cTextoBusqueda) {
        return clienteRepository.buscar(cTextoBusqueda);
    }

    @Override
    public Optional<Cliente> obtenerPorId(Integer nClienteId) {
        return clienteRepository.obtenerPorId(nClienteId);
    }

    @Override
    public ExisteDocumentoDTO existeDocumento(Integer nTipoDocumentoId, String cNumeroDocumento) {
        return clienteRepository.existeDocumento(nTipoDocumentoId, cNumeroDocumento);
    }

    @Override
    public ClienteCreatedDTO crear(ClienteRequest request) {
        return clienteRepository.insertar(
                request.getNTipoDocumentoId(),
                request.getCNumeroDocumento(),
                request.getCNombres(),
                request.getCApellidoPaterno(),
                request.getCApellidoMaterno(),
                request.getCSexo(),
                request.getDFechaNacimiento(),
                request.getCTelefono(),
                request.getCEmail(),
                request.getCDireccion(),
                request.getCRazonSocial(),
                request.getCNombreComercial(),
                request.getCObservaciones()
        );
    }

    @Override
    public void actualizar(Integer nClienteId, ClienteRequest request) {
        clienteRepository.actualizar(
                nClienteId,
                request.getNTipoDocumentoId(),
                request.getCNumeroDocumento(),
                request.getCNombres(),
                request.getCApellidoPaterno(),
                request.getCApellidoMaterno(),
                request.getCSexo(),
                request.getDFechaNacimiento(),
                request.getCTelefono(),
                request.getCEmail(),
                request.getCDireccion(),
                request.getCRazonSocial(),
                request.getCNombreComercial(),
                request.getCObservaciones(),
                request.getBEstado()
        );
    }

    @Override
    public void eliminar(Integer nClienteId) {
        clienteRepository.eliminar(nClienteId);
    }

    @Override
    public ClienteBusquedaDTO buscarPorDocumento(String cNumeroDocumento) {
        return clienteRepository.buscarPorDocumento(cNumeroDocumento);
    }
}