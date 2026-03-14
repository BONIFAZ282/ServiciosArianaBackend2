package com.serviciosariana.app.servicio.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoServicio {
    private Integer nTipoServicioId;
    private String cTipoServicioCod;
    private String cNombre;
    private String cDescripcion;
    private BigDecimal nPrecioBase;
    private LocalDateTime dFechaCreacion;
    private Boolean bEstado;
}