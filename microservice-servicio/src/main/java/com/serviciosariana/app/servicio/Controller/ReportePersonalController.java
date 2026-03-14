package com.serviciosariana.app.servicio.Controller;

import com.serviciosariana.app.servicio.Model.dto.*;
import com.serviciosariana.app.servicio.Services.ReportePersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicio/reportes/personal")
public class ReportePersonalController {

    @Autowired
    private ReportePersonalService reportePersonalService;

    @GetMapping("/{id}/resumen")
    public ResponseEntity<ResumenPersonalDTO> obtenerResumen(@PathVariable("id") Integer nPersonalId) {
        return ResponseEntity.ok(reportePersonalService.obtenerResumen(nPersonalId));
    }

    @GetMapping("/{id}/ordenes")
    public ResponseEntity<List<OrdenPersonalDTO>> listarOrdenes(@PathVariable("id") Integer nPersonalId) {
        return ResponseEntity.ok(reportePersonalService.listarOrdenes(nPersonalId));
    }

    @GetMapping("/ranking")
    public ResponseEntity<List<RankingPersonalDTO>> listarRanking() {
        return ResponseEntity.ok(reportePersonalService.listarRanking());
    }

    @GetMapping("/carga-trabajo")
    public ResponseEntity<List<CargaTrabajoDTO>> listarCargaTrabajo() {
        return ResponseEntity.ok(reportePersonalService.listarCargaTrabajo());
    }
}