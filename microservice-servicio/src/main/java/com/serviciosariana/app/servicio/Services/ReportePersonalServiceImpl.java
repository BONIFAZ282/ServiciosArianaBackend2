package com.serviciosariana.app.servicio.Services;

import com.serviciosariana.app.servicio.Model.dto.*;
import com.serviciosariana.app.servicio.Repository.ReportePersonalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportePersonalServiceImpl implements ReportePersonalService {

    @Autowired
    private ReportePersonalRepository reportePersonalRepository;

    @Override
    public ResumenPersonalDTO obtenerResumen(Integer nPersonalId) {
        return reportePersonalRepository.obtenerResumen(nPersonalId);
    }

    @Override
    public List<RankingPersonalDTO> listarRanking() {
        return reportePersonalRepository.listarRanking();
    }

    @Override
    public List<CargaTrabajoDTO> listarCargaTrabajo() {
        return reportePersonalRepository.listarCargaTrabajo();
    }

    @Override
    public List<OrdenPersonalDTO> listarOrdenes(Integer nPersonalId) {
        return reportePersonalRepository.listarOrdenes(nPersonalId);
    }
}