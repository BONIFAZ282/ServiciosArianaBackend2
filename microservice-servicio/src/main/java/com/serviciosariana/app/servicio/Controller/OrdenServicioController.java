package com.serviciosariana.app.servicio.Controller;

import com.serviciosariana.app.servicio.Model.OrdenServicio;
import com.serviciosariana.app.servicio.Model.OrdenServicioHistorial;
import com.serviciosariana.app.servicio.Model.dto.*;
import com.serviciosariana.app.servicio.Services.OrdenServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicio/ordenes")
public class OrdenServicioController {

    @Autowired
    private OrdenServicioService ordenServicioService;

    @GetMapping
    public ResponseEntity<List<OrdenServicio>> listarTodos() {
        return ResponseEntity.ok(ordenServicioService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdenServicio> obtenerPorId(@PathVariable("id") Integer nOrdenServicioId) {
        return ResponseEntity.ok(ordenServicioService.obtenerPorId(nOrdenServicioId));
    }

    @GetMapping("/{id}/historial")
    public ResponseEntity<List<OrdenServicioHistorial>> listarHistorial(@PathVariable("id") Integer nOrdenServicioId) {
        return ResponseEntity.ok(ordenServicioService.listarHistorial(nOrdenServicioId));
    }

    @PostMapping
    public ResponseEntity<OrdenServicioCreatedDTO> crear(@RequestBody OrdenServicioRequest request) {
        OrdenServicioCreatedDTO created = ordenServicioService.crear(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Integer> actualizar(
            @PathVariable("id") Integer nOrdenServicioId,
            @RequestBody OrdenServicioRequest request) {
        Integer updated = ordenServicioService.actualizar(nOrdenServicioId, request);
        return ResponseEntity.ok(updated);
    }

    @PutMapping("/{id}/estado")
    public ResponseEntity<Void> cambiarEstado(
            @PathVariable("id") Integer nOrdenServicioId,
            @RequestBody CambiarEstadoRequest request) {
        ordenServicioService.cambiarEstado(
                nOrdenServicioId,
                request.getCEstadoOrdenCodNuevo(),
                request.getCComentario(),
                request.getNUsuarioId()
        );
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer nOrdenServicioId) {
        ordenServicioService.eliminar(nOrdenServicioId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/lider/{liderId}/equipo")
    public ResponseEntity<List<EquipoLiderDTO>> listarEquipoPorLider(
            @PathVariable("liderId") Integer nPersonalLiderId) {
        return ResponseEntity.ok(ordenServicioService.listarEquipoPorLider(nPersonalLiderId));
    }

    @GetMapping("/lider/{liderId}/resumen")
    public ResponseEntity<List<OrdenResumenLiderDTO>> listarResumenPorLider(
            @PathVariable("liderId") Integer nPersonalLiderId) {
        return ResponseEntity.ok(ordenServicioService.listarResumenPorLider(nPersonalLiderId));
    }
}