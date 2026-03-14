package com.serviciosariana.app.servicio.Model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EstadoReporteDTO {
    private String cEstadoOrdenCod;
    private String cEstadoNombre;
    private String cColor;
    private Integer nCantidad;
}