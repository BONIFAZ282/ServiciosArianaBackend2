package com.serviciosariana.app.servicio.Repository;

import com.serviciosariana.app.servicio.Model.dto.*;
import java.util.List;

public interface ReportePersonalRepository {

    ResumenPersonalDTO obtenerResumen(Integer nPersonalId);

    List<RankingPersonalDTO> listarRanking();

    List<CargaTrabajoDTO> listarCargaTrabajo();

    List<OrdenPersonalDTO> listarOrdenes(Integer nPersonalId);
}