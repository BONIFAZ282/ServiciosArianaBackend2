package com.serviciosariana.app.security.Controller;


import com.serviciosariana.app.security.Model.Usuario;
import com.serviciosariana.app.security.Model.dto.*;
import com.serviciosariana.app.security.Services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/security/usuarios")
public class UsuarioController {
    // Versión 2.0 - Login endpoint fixed

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioListDTO>> listarTodos() {
        List<UsuarioListDTO> usuarios = usuarioService.listarTodos();
        return ResponseEntity.ok(usuarios);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) {
        System.out.println("========================================");
        System.out.println("LOGIN ENDPOINT CALLED - METHOD: POST");
        System.out.println("Usuario: " + request.getCUsuario());
        System.out.println("========================================");

        LoginResponse response = usuarioService.login(request.getCUsuario(), request.getCPassword());

        if (response.getBExitoso()) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }

    @GetMapping("/{id:[0-9]+}")
    public ResponseEntity<Usuario> obtenerPorId(@PathVariable("id") Integer nUsuarioId) {
        return usuarioService.obtenerPorId(nUsuarioId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<Usuario> obtenerPorUsuario(@PathVariable("username") String cUsuario) {
        return usuarioService.obtenerPorUsuario(cUsuario)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/bloqueado/{username}")
    public ResponseEntity<BloqueoResponse> verificarBloqueo(@PathVariable("username") String cUsuario) {
        BloqueoResponse response = usuarioService.verificarBloqueo(cUsuario);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Integer> crear(@Valid @RequestBody UsuarioCreateRequest request) {
        Integer nUsuarioId = usuarioService.crear(
                request.getNPersonalId(),
                request.getCUsuario(),
                request.getCPassword()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(nUsuarioId);
    }

    @PatchMapping("/{id}/password")
    public ResponseEntity<Void> cambiarPassword(
            @PathVariable("id") Integer nUsuarioId,
            @Valid @RequestBody CambiarPasswordRequest request) {
        usuarioService.cambiarPassword(nUsuarioId, request.getCPassword());
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}/estado/{estado}")
    public ResponseEntity<Void> cambiarEstado(
            @PathVariable("id") Integer nUsuarioId,
            @PathVariable("estado") Boolean bEstado) {
        usuarioService.cambiarEstado(nUsuarioId, bEstado);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}/desbloquear")
    public ResponseEntity<Void> desbloquear(@PathVariable("id") Integer nUsuarioId) {
        usuarioService.desbloquear(nUsuarioId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/intento-fallido/{username}")
    public ResponseEntity<IntentoFallidoResponse> registrarIntentoFallido(
            @PathVariable("username") String cUsuario) {
        IntentoFallidoResponse response = usuarioService.registrarIntentoFallido(cUsuario);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}/acceso-exitoso")
    public ResponseEntity<Void> registrarAccesoExitoso(@PathVariable("id") Integer nUsuarioId) {
        usuarioService.registrarAccesoExitoso(nUsuarioId);
        return ResponseEntity.ok().build();
    }

}