package com.serviciosariana.app.servicio.Repository;

import com.serviciosariana.app.servicio.Model.dto.*;
import java.util.List;

public interface ReporteDashboardRepository {

    ResumenDashboardDTO obtenerResumen();

    List<EstadoReporteDTO> listarPorEstado();

    List<PrioridadReporteDTO> listarPorPrioridad();

    List<MesReporteDTO> listarPorMes();

    List<TopClienteDTO> listarTopClientes();

    List<TopServicioDTO> listarTopServicios();

    List<OrdenVencidaDTO> listarOrdenesVencidas();
}