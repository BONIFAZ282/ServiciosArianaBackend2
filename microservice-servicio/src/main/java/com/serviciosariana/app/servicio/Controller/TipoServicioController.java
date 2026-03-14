package com.serviciosariana.app.servicio.Controller;

import com.serviciosariana.app.servicio.Model.TipoServicio;
import com.serviciosariana.app.servicio.Model.dto.TipoServicioComboDTO;
import com.serviciosariana.app.servicio.Model.dto.TipoServicioRequest;
import com.serviciosariana.app.servicio.Services.TipoServicioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicio/tipos-servicio")
public class TipoServicioController {

    @Autowired
    private TipoServicioService tipoServicioService;

    @GetMapping
    public ResponseEntity<List<TipoServicio>> listarTodos() {
        return ResponseEntity.ok(tipoServicioService.listarTodos());
    }

    @PostMapping
    public ResponseEntity<Integer> crear(@Valid @RequestBody TipoServicioRequest request) {
        Integer nTipoServicioId = tipoServicioService.crear(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(nTipoServicioId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> actualizar(
            @PathVariable("id") Integer nTipoServicioId,
            @Valid @RequestBody TipoServicioRequest request) {
        tipoServicioService.actualizar(nTipoServicioId, request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer nTipoServicioId) {
        tipoServicioService.eliminar(nTipoServicioId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/combo")
    public ResponseEntity<List<TipoServicioComboDTO>> listarParaCombo() {
        return ResponseEntity.ok(tipoServicioService.listarParaCombo());
    }
}