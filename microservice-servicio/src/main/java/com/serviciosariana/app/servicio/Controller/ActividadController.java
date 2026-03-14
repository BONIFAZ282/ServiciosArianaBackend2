package com.serviciosariana.app.servicio.Controller;

import com.serviciosariana.app.servicio.Model.Actividad;
import com.serviciosariana.app.servicio.Model.ActividadEvidencia;
import com.serviciosariana.app.servicio.Model.dto.ActividadRequest;
import com.serviciosariana.app.servicio.Model.dto.EvidenciaRequest;
import com.serviciosariana.app.servicio.Services.ActividadEvidenciaService;
import com.serviciosariana.app.servicio.Services.ActividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicio/actividades")
public class ActividadController {

    @Autowired
    private ActividadService actividadService;

    @Autowired
    private ActividadEvidenciaService actividadEvidenciaService;

    // ==================== ACTIVIDAD ====================

    @GetMapping("/orden/{ordenId}")
    public ResponseEntity<List<Actividad>> listarPorOrden(@PathVariable("ordenId") Integer nOrdenServicioId) {
        return ResponseEntity.ok(actividadService.listarPorOrden(nOrdenServicioId));
    }

    @GetMapping("/personal/{personalId}")
    public ResponseEntity<List<Actividad>> listarPorPersonal(@PathVariable("personalId") Integer nPersonalId) {
        return ResponseEntity.ok(actividadService.listarPorPersonal(nPersonalId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Actividad> obtenerPorId(@PathVariable("id") Integer nActividadId) {
        return ResponseEntity.ok(actividadService.obtenerPorId(nActividadId));
    }

    @PostMapping
    public ResponseEntity<Integer> crear(@RequestBody ActividadRequest request) {
        Integer nActividadId = actividadService.crear(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(nActividadId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Integer> actualizar(
            @PathVariable("id") Integer nActividadId,
            @RequestBody ActividadRequest request) {
        return ResponseEntity.ok(actividadService.actualizar(nActividadId, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer nActividadId) {
        actividadService.eliminar(nActividadId);
        return ResponseEntity.noContent().build();
    }

    // ==================== EVIDENCIA ====================

    @GetMapping("/{actividadId}/evidencias")
    public ResponseEntity<List<ActividadEvidencia>> listarEvidencias(
            @PathVariable("actividadId") Integer nActividadId) {
        return ResponseEntity.ok(actividadEvidenciaService.listarPorActividad(nActividadId));
    }

    @GetMapping("/evidencias/{evidenciaId}")
    public ResponseEntity<ActividadEvidencia> obtenerEvidencia(
            @PathVariable("evidenciaId") Integer nActividadEvidenciaId) {
        return ResponseEntity.ok(actividadEvidenciaService.obtenerPorId(nActividadEvidenciaId));
    }

    @PostMapping("/{actividadId}/evidencias")
    public ResponseEntity<Integer> agregarEvidencia(
            @PathVariable("actividadId") Integer nActividadId,
            @RequestBody EvidenciaRequest request) {
        Integer nActividadEvidenciaId = actividadEvidenciaService.agregar(nActividadId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(nActividadEvidenciaId);
    }

    @DeleteMapping("/evidencias/{evidenciaId}")
    public ResponseEntity<Void> eliminarEvidencia(
            @PathVariable("evidenciaId") Integer nActividadEvidenciaId) {
        actividadEvidenciaService.eliminar(nActividadEvidenciaId);
        return ResponseEntity.noContent().build();
    }
}