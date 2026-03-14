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
public class TopClienteDTO {
    private Integer nClienteId;
    private String cClienteNombre;
    private Integer nTotalOrdenes;
    private BigDecimal nTotalFacturado;
}