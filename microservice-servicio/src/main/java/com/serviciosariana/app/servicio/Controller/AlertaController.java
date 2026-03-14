package com.serviciosariana.app.servicio.Controller;

import com.serviciosariana.app.servicio.Model.dto.AlertaDTO;
import com.serviciosariana.app.servicio.Model.dto.ContadorAlertasDTO;
import com.serviciosariana.app.servicio.Model.dto.MarcarLeidaRequest;
import com.serviciosariana.app.servicio.Services.AlertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/servicio/alertas")
public class AlertaController {

    @Autowired
    private AlertaService alertaService;

    // Generar alertas automáticas (ejecutar manualmente o con Job)
    @PostMapping("/generar")
    public ResponseEntity<Map<String, Integer>> generarAutomaticas() {
        Integer generadas = alertaService.generarAutomaticas();
        return ResponseEntity.ok(Map.of("nAlertasGeneradas", generadas));
    }

    // Listar alertas (todas o por líder)
    @GetMapping
    public ResponseEntity<List<AlertaDTO>> listarTodos(
            @RequestParam(value = "personalId", required = false) Integer nPersonalId,
            @RequestParam(value = "soloNoLeidas", required = false, defaultValue = "false") Boolean bSoloNoLeidas) {
        return ResponseEntity.ok(alertaService.listarTodos(nPersonalId, bSoloNoLeidas));
    }

    // Contador de alertas no leídas (para badge)
    @GetMapping("/contador")
    public ResponseEntity<ContadorAlertasDTO> contadorNoLeidas(
            @RequestParam(value = "personalId", required = false) Integer nPersonalId) {
        return ResponseEntity.ok(alertaService.contadorNoLeidas(nPersonalId));
    }

    // Obtener alerta por ID
    @GetMapping("/{id}")
    public ResponseEntity<AlertaDTO> obtenerPorId(@PathVariable("id") Integer nAlertaId) {
        return ResponseEntity.ok(alertaService.obtenerPorId(nAlertaId));
    }

    // Marcar una alerta como leída
    @PatchMapping("/{id}/leida")
    public ResponseEntity<Void> marcarLeida(
            @PathVariable("id") Integer nAlertaId,
            @RequestBody MarcarLeidaRequest request) {
        alertaService.marcarLeida(nAlertaId, request.getNUsuarioId());
        return ResponseEntity.ok().build();
    }

    // Marcar todas como leídas
    @PatchMapping("/marcar-todas-leidas")
    public ResponseEntity<Map<String, Integer>> marcarTodasLeidas(
            @RequestParam(value = "personalId", required = false) Integer nPersonalId,
            @RequestBody MarcarLeidaRequest request) {
        Integer marcadas = alertaService.marcarTodasLeidas(nPersonalId, request.getNUsuarioId());
        return ResponseEntity.ok(Map.of("nAlertasMarcadas", marcadas));
    }

    @PatchMapping("/{id}/resuelta")
    public ResponseEntity<Void> marcarResuelta(
            @PathVariable("id") Integer nAlertaId,
            @RequestBody MarcarLeidaRequest request) {
        alertaService.marcarResuelta(nAlertaId, request.getNUsuarioId());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/enviar-notificaciones")
    public ResponseEntity<Map<String, Integer>> enviarNotificaciones() {
        Integer enviados = alertaService.enviarNotificacionesPendientes();
        return ResponseEntity.ok(Map.of("nCorreosEnviados", enviados));
    }
}