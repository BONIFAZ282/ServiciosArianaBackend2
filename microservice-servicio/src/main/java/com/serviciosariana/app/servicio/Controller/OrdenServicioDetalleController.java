package com.serviciosariana.app.servicio.Controller;

import com.serviciosariana.app.servicio.Model.OrdenServicioDetalle;
import com.serviciosariana.app.servicio.Model.dto.OrdenServicioDetalleRequest;
import com.serviciosariana.app.servicio.Model.dto.OrdenTotalDTO;
import com.serviciosariana.app.servicio.Services.OrdenServicioDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicio/ordenes")
public class OrdenServicioDetalleController {

    @Autowired
    private OrdenServicioDetalleService ordenServicioDetalleService;

    @GetMapping("/{ordenId}/servicios")
    public ResponseEntity<List<OrdenServicioDetalle>> listarServicios(
            @PathVariable("ordenId") Integer nOrdenServicioId) {
        return ResponseEntity.ok(ordenServicioDetalleService.listarPorOrden(nOrdenServicioId));
    }

    @GetMapping("/{ordenId}/servicios/total")
    public ResponseEntity<OrdenTotalDTO> obtenerTotal(
            @PathVariable("ordenId") Integer nOrdenServicioId) {
        return ResponseEntity.ok(ordenServicioDetalleService.obtenerTotalOrden(nOrdenServicioId));
    }

    @PostMapping("/{ordenId}/servicios")
    public ResponseEntity<Integer> agregarServicio(
            @PathVariable("ordenId") Integer nOrdenServicioId,
            @RequestBody OrdenServicioDetalleRequest request) {
        Integer nOrdenServicioDetalleId = ordenServicioDetalleService.agregar(nOrdenServicioId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(nOrdenServicioDetalleId);
    }

    @PutMapping("/servicios/{detalleId}")
    public ResponseEntity<Integer> actualizarServicio(
            @PathVariable("detalleId") Integer nOrdenServicioDetalleId,
            @RequestBody OrdenServicioDetalleRequest request) {
        return ResponseEntity.ok(ordenServicioDetalleService.actualizar(nOrdenServicioDetalleId, request));
    }

    @DeleteMapping("/servicios/{detalleId}")
    public ResponseEntity<Void> quitarServicio(
            @PathVariable("detalleId") Integer nOrdenServicioDetalleId) {
        ordenServicioDetalleService.quitar(nOrdenServicioDetalleId);
        return ResponseEntity.noContent().build();
    }
}