package com.serviciosariana.app.servicio.Services;

import com.serviciosariana.app.servicio.Model.dto.*;
import com.serviciosariana.app.servicio.Repository.ReporteDashboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReporteDashboardServiceImpl implements ReporteDashboardService {

    @Autowired
    private ReporteDashboardRepository reporteDashboardRepository;

    @Override
    public ResumenDashboardDTO obtenerResumen() {
        return reporteDashboardRepository.obtenerResumen();
    }

    @Override
    public List<EstadoReporteDTO> listarPorEstado() {
        return reporteDashboardRepository.listarPorEstado();
    }

    @Override
    public List<PrioridadReporteDTO> listarPorPrioridad() {
        return reporteDashboardRepository.listarPorPrioridad();
    }

    @Override
    public List<MesReporteDTO> listarPorMes() {
        return reporteDashboardRepository.listarPorMes();
    }

    @Override
    public List<TopClienteDTO> listarTopClientes() {
        return reporteDashboardRepository.listarTopClientes();
    }

    @Override
    public List<TopServicioDTO> listarTopServicios() {
        return reporteDashboardRepository.listarTopServicios();
    }

    @Override
    public List<OrdenVencidaDTO> listarOrdenesVencidas() {
        return reporteDashboardRepository.listarOrdenesVencidas();
    }
}