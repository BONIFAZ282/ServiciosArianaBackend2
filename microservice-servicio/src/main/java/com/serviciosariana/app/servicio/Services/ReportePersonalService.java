package com.serviciosariana.app.servicio.Services;

import com.serviciosariana.app.servicio.Model.dto.*;
import java.util.List;

public interface ReportePersonalService {

    ResumenPersonalDTO obtenerResumen(Integer nPersonalId);

    List<RankingPersonalDTO> listarRanking();

    List<CargaTrabajoDTO> listarCargaTrabajo();

    List<OrdenPersonalDTO> listarOrdenes(Integer nPersonalId);
}