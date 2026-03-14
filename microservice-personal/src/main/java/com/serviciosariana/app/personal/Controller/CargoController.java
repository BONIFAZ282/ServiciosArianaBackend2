package com.serviciosariana.app.personal.Controller;

import com.serviciosariana.app.personal.Model.Cargo;
import com.serviciosariana.app.personal.Model.dto.CargoRequest;
import com.serviciosariana.app.personal.Services.CargoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personal/cargos")
public class CargoController {

    @Autowired
    private CargoService cargoService;

    @GetMapping
    public ResponseEntity<List<Cargo>> listarTodos() {
        return ResponseEntity.ok(cargoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cargo> obtenerPorId(@PathVariable("id") Integer nCargoId) {
        return cargoService.obtenerPorId(nCargoId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Integer> crear(@Valid @RequestBody CargoRequest request) {
        Integer nCargoId = cargoService.crear(
                request.getCCargoCod(),
                request.getCNombre(),
                request.getCDescripcion()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(nCargoId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> actualizar(
            @PathVariable("id") Integer nCargoId,
            @Valid @RequestBody CargoRequest request) {
        cargoService.actualizar(
                nCargoId,
                request.getCCargoCod(),
                request.getCNombre(),
                request.getCDescripcion(),
                request.getBEstado()
        );
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer nCargoId) {
        cargoService.eliminar(nCargoId);
        return ResponseEntity.noContent().build();
    }
}