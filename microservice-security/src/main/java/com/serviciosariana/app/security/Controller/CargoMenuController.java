package com.serviciosariana.app.security.Controller;

import com.serviciosariana.app.security.Model.CargoMenu;
import com.serviciosariana.app.security.Model.dto.CargoMenuRequest;
import com.serviciosariana.app.security.Model.dto.MenuSidebarDTO;
import com.serviciosariana.app.security.Model.dto.PermisosRequest;
import com.serviciosariana.app.security.Services.CargoMenuService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/security/cargo-menus")
public class CargoMenuController {

    @Autowired
    private CargoMenuService cargoMenuService;

    @GetMapping("/cargo/{cargoId}")
    public ResponseEntity<List<CargoMenu>> listarPorCargo(@PathVariable("cargoId") Integer nCargoId) {
        return ResponseEntity.ok(cargoMenuService.listarPorCargo(nCargoId));
    }

    @GetMapping("/sidebar/{cargoId}")
    public ResponseEntity<List<MenuSidebarDTO>> listarMenusSidebar(@PathVariable("cargoId") Integer nCargoId) {
        return ResponseEntity.ok(cargoMenuService.listarMenusSidebar(nCargoId));
    }

    @GetMapping("/main/{cargoId}")
    public ResponseEntity<List<MenuSidebarDTO>> listarMenusPrincipal(@PathVariable("cargoId") Integer nCargoId) {
        return ResponseEntity.ok(cargoMenuService.listarMenusPrincipal(nCargoId));
    }

    @PostMapping
    public ResponseEntity<Integer> asignar(@Valid @RequestBody CargoMenuRequest request) {
        Integer nCargoMenuId = cargoMenuService.asignar(
                request.getNCargoId(),
                request.getNMenuId(),
                request.getBVer() != null ? request.getBVer() : true,
                request.getBCrear() != null ? request.getBCrear() : false,
                request.getBEditar() != null ? request.getBEditar() : false,
                request.getBEliminar() != null ? request.getBEliminar() : false
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(nCargoMenuId);
    }

    @PatchMapping("/{id}/permisos")
    public ResponseEntity<Void> actualizarPermisos(
            @PathVariable("id") Integer nCargoMenuId,
            @RequestBody PermisosRequest request) {
        cargoMenuService.actualizarPermisos(
                nCargoMenuId,
                request.getBVer(),
                request.getBCrear(),
                request.getBEditar(),
                request.getBEliminar(),
                request.getBEstado()
        );
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer nCargoMenuId) {
        cargoMenuService.eliminar(nCargoMenuId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/cargo/{cargoId}")
    public ResponseEntity<Void> eliminarTodosPorCargo(@PathVariable("cargoId") Integer nCargoId) {
        cargoMenuService.eliminarTodosPorCargo(nCargoId);
        return ResponseEntity.noContent().build();
    }
}