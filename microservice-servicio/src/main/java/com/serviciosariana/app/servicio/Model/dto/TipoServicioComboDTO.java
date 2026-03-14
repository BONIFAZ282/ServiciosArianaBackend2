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
public class TipoServicioComboDTO {
    private Integer nTipoServicioId;
    private String cNombre;
    private BigDecimal nPrecioBase;
}