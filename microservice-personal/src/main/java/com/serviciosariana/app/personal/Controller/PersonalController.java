package com.serviciosariana.app.personal.Controller;

import com.serviciosariana.app.personal.Model.Personal;
import com.serviciosariana.app.personal.Model.dto.LiderDTO;
import com.serviciosariana.app.personal.Model.dto.PersonalConLiderDTO;
import com.serviciosariana.app.personal.Model.dto.PersonalListDTO;
import com.serviciosariana.app.personal.Model.dto.PersonalRequest;
import com.serviciosariana.app.personal.Services.PersonalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personal/empleados")
public class PersonalController {

    @Autowired
    private PersonalService personalService;

    @GetMapping
    public ResponseEntity<List<PersonalListDTO>> listarTodos() {
        return ResponseEntity.ok(personalService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Personal> obtenerPorId(@PathVariable("id") Integer nPersonalId) {
        return personalService.obtenerPorId(nPersonalId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/cargo/{cargoId}")
    public ResponseEntity<List<PersonalListDTO>> listarPorCargo(@PathVariable("cargoId") Integer nCargoId) {
        return ResponseEntity.ok(personalService.listarPorCargo(nCargoId));
    }

    @GetMapping("/lider/{liderId}")
    public ResponseEntity<List<PersonalListDTO>> listarPorLider(@PathVariable("liderId") Integer nPersonalLiderId) {
        return ResponseEntity.ok(personalService.listarPorLider(nPersonalLiderId));
    }

    @GetMapping("/lideres")
    public ResponseEntity<List<LiderDTO>> listarLideres() {
        return ResponseEntity.ok(personalService.listarLideres());
    }

    @PostMapping
    public ResponseEntity<Integer> crear(@Valid @RequestBody PersonalRequest request) {
        Integer nPersonalId = personalService.crear(
                request.getPersona(),
                request.getNCargoId(),
                request.getNPersonalLiderId(),
                request.getDFechaIngreso(),
                request.getNSueldo(),
                request.getCObservaciones()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(nPersonalId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> actualizar(
            @PathVariable("id") Integer nPersonalId,
            @Valid @RequestBody PersonalRequest request) {
        personalService.actualizar(
                nPersonalId,
                request.getNCargoId(),
                request.getNPersonalLiderId(),
                request.getDFechaIngreso(),
                request.getDFechaCese(),
                request.getNSueldo(),
                request.getCObservaciones(),
                request.getBEstado()
        );
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer nPersonalId) {
        personalService.eliminar(nPersonalId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/lideresxTrabajador")
    public ResponseEntity<List<PersonalConLiderDTO>> listarConLider() {
        return ResponseEntity.ok(personalService.listarConLider());
    }
}