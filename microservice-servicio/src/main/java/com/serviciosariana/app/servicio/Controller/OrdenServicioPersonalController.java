package com.serviciosariana.app.servicio.Controller;

import com.serviciosariana.app.servicio.Model.OrdenServicioPersonal;
import com.serviciosariana.app.servicio.Model.dto.AsignarPersonalRequest;
import com.serviciosariana.app.servicio.Model.dto.PersonalDisponibleDTO;
import com.serviciosariana.app.servicio.Services.OrdenServicioPersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicio/ordenes")
public class OrdenServicioPersonalController {

    @Autowired
    private OrdenServicioPersonalService ordenServicioPersonalService;

    @GetMapping("/{ordenId}/personal")
    public ResponseEntity<List<OrdenServicioPersonal>> listarPersonalAsignado(
            @PathVariable("ordenId") Integer nOrdenServicioId) {
        return ResponseEntity.ok(ordenServicioPersonalService.listarPorOrden(nOrdenServicioId));
    }

    @GetMapping("/{ordenId}/personal/disponibles")
    public ResponseEntity<List<PersonalDisponibleDTO>> listarPersonalDisponible(
            @PathVariable("ordenId") Integer nOrdenServicioId) {
        return ResponseEntity.ok(ordenServicioPersonalService.listarDisponibles(nOrdenServicioId));
    }

    @PostMapping("/{ordenId}/personal")
    public ResponseEntity<Integer> asignarPersonal(
            @PathVariable("ordenId") Integer nOrdenServicioId,
            @RequestBody AsignarPersonalRequest request) {
        Integer nOrdenServicioPersonalId = ordenServicioPersonalService.asignar(
                nOrdenServicioId,
                request.getNPersonalId(),
                request.getCObservaciones()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(nOrdenServicioPersonalId);
    }

    @DeleteMapping("/{ordenId}/personal/{personalId}")
    public ResponseEntity<Void> desasignarPersonal(
            @PathVariable("ordenId") Integer nOrdenServicioId,
            @PathVariable("personalId") Integer nPersonalId) {
        ordenServicioPersonalService.desasignar(nOrdenServicioId, nPersonalId);
        return ResponseEntity.noContent().build();
    }
}