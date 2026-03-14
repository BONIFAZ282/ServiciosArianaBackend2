package com.serviciosariana.app.servicio.Services;

import com.serviciosariana.app.servicio.Model.dto.*;
import java.util.List;

public interface ReporteDashboardService {

    ResumenDashboardDTO obtenerResumen();

    List<EstadoReporteDTO> listarPorEstado();

    List<PrioridadReporteDTO> listarPorPrioridad();

    List<MesReporteDTO> listarPorMes();

    List<TopClienteDTO> listarTopClientes();

    List<TopServicioDTO> listarTopServicios();

    List<OrdenVencidaDTO> listarOrdenesVencidas();
}