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
public class MesReporteDTO {
    private Integer nAnio;
    private Integer nMes;
    private String cMesAnio;
    private Integer nCantidad;
    private BigDecimal nIngresos;
}