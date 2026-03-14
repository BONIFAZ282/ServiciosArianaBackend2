package com.serviciosariana.app.servicio.Model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResumenDashboardDTO {
    private Integer nTotalOrdenes;
    private Integer nPendientes;
    private Integer nEnProceso;
    private Integer nFinalizadas;
    private Integer nResueltas;
    private Integer nCanceladas;
    private Integer nObservadas;
    private BigDecimal nTotalEstimado;
    private BigDecimal nTotalReal;
    private Integer nTotalClientes;
    private Integer nTotalPersonal;
}