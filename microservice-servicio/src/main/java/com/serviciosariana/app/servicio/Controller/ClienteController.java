package com.serviciosariana.app.servicio.Controller;

import com.serviciosariana.app.servicio.Model.Cliente;
import com.serviciosariana.app.servicio.Model.dto.*;
import com.serviciosariana.app.servicio.Services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicio/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteListDTO>> listarTodos() {
        return ResponseEntity.ok(clienteService.listarTodos());
    }

    @GetMapping("/combo")
    public ResponseEntity<List<ClienteComboDTO>> listarCombo() {
        return ResponseEntity.ok(clienteService.listarCombo());
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<ClienteListDTO>> buscar(@RequestParam("q") String cTextoBusqueda) {
        return ResponseEntity.ok(clienteService.buscar(cTextoBusqueda));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> obtenerPorId(@PathVariable("id") Integer nClienteId) {
        return clienteService.obtenerPorId(nClienteId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/existe-documento")
    public ResponseEntity<ExisteDocumentoDTO> existeDocumento(
            @RequestParam("tipoDocumento") Integer nTipoDocumentoId,
            @RequestParam("documento") String cNumeroDocumento) {
        return ResponseEntity.ok(clienteService.existeDocumento(nTipoDocumentoId, cNumeroDocumento));
    }

    @PostMapping
    public ResponseEntity<ClienteCreatedDTO> crear(@Valid @RequestBody ClienteRequest request) {
        ClienteCreatedDTO cliente = clienteService.crear(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> actualizar(
            @PathVariable("id") Integer nClienteId,
            @Valid @RequestBody ClienteRequest request) {
        clienteService.actualizar(nClienteId, request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer nClienteId) {
        clienteService.eliminar(nClienteId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/documento/{numeroDocumento}")
    public ResponseEntity<ClienteBusquedaDTO> buscarPorDocumento(
            @PathVariable("numeroDocumento") String cNumeroDocumento) {
        return ResponseEntity.ok(clienteService.buscarPorDocumento(cNumeroDocumento));
    }
}