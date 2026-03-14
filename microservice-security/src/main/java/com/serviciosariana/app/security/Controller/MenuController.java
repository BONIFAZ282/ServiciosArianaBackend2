package com.serviciosariana.app.security.Controller;

import com.serviciosariana.app.security.Model.Menu;
import com.serviciosariana.app.security.Model.dto.MenuPadreDTO;
import com.serviciosariana.app.security.Model.dto.MenuRequest;
import com.serviciosariana.app.security.Services.MenuService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/security/menus")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping
    public ResponseEntity<List<Menu>> listarTodos() {
        return ResponseEntity.ok(menuService.listarTodos());
    }

    @GetMapping("/padres")
    public ResponseEntity<List<MenuPadreDTO>> listarPadres() {
        return ResponseEntity.ok(menuService.listarPadres());
    }

    @GetMapping("/{id:[0-9]+}")
    public ResponseEntity<Menu> obtenerPorId(@PathVariable("id") Integer nMenuId) {
        return menuService.obtenerPorId(nMenuId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Integer> crear(@Valid @RequestBody MenuRequest request) {
        Integer nMenuId = menuService.crear(
                request.getCMenuCod(),
                request.getCNombre(),
                request.getCDescripcion(),
                request.getCRuta(),
                request.getCIcono(),
                request.getNMenuPadreId(),
                request.getNOrden()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(nMenuId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> actualizar(
            @PathVariable("id") Integer nMenuId,
            @Valid @RequestBody MenuRequest request) {
        menuService.actualizar(
                nMenuId,
                request.getCMenuCod(),
                request.getCNombre(),
                request.getCDescripcion(),
                request.getCRuta(),
                request.getCIcono(),
                request.getNMenuPadreId(),
                request.getNOrden(),
                request.getBEstado()
        );
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer nMenuId) {
        menuService.eliminar(nMenuId);
        return ResponseEntity.noContent().build();
    }
}