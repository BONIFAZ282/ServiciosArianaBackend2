package com.serviciosariana.app.servicio.Model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PrioridadReporteDTO {
    private String cPrioridadCod;
    private String cPrioridadNombre;
    private String cColor;
    private Integer nCantidad;
}