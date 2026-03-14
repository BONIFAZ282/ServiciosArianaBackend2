package com.serviciosariana.app.servicio.Controller;

import com.serviciosariana.app.servicio.Model.dto.*;
import com.serviciosariana.app.servicio.Services.ReporteDashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicio/reportes/dashboard")
public class ReporteDashboardController {

    @Autowired
    private ReporteDashboardService reporteDashboardService;

    @GetMapping("/resumen")
    public ResponseEntity<ResumenDashboardDTO> obtenerResumen() {
        return ResponseEntity.ok(reporteDashboardService.obtenerResumen());
    }

    @GetMapping("/por-estado")
    public ResponseEntity<List<EstadoReporteDTO>> listarPorEstado() {
        return ResponseEntity.ok(reporteDashboardService.listarPorEstado());
    }

    @GetMapping("/por-prioridad")
    public ResponseEntity<List<PrioridadReporteDTO>> listarPorPrioridad() {
        return ResponseEntity.ok(reporteDashboardService.listarPorPrioridad());
    }

    @GetMapping("/por-mes")
    public ResponseEntity<List<MesReporteDTO>> listarPorMes() {
        return ResponseEntity.ok(reporteDashboardService.listarPorMes());
    }

    @GetMapping("/top-clientes")
    public ResponseEntity<List<TopClienteDTO>> listarTopClientes() {
        return ResponseEntity.ok(reporteDashboardService.listarTopClientes());
    }

    @GetMapping("/top-servicios")
    public ResponseEntity<List<TopServicioDTO>> listarTopServicios() {
        return ResponseEntity.ok(reporteDashboardService.listarTopServicios());
    }

    @GetMapping("/ordenes-vencidas")
    public ResponseEntity<List<OrdenVencidaDTO>> listarOrdenesVencidas() {
        return ResponseEntity.ok(reporteDashboardService.listarOrdenesVencidas());
    }
}