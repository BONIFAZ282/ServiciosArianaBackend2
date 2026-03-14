package com.serviciosariana.app.servicio.Model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class OrdenServicioDetalleRequest {
    @JsonProperty("nTipoServicioId")
    private Integer nTipoServicioId;

    @JsonProperty("cDescripcion")
    private String cDescripcion;

    @JsonProperty("nCantidad")
    private Integer nCantidad;

    @JsonProperty("nPrecioUnitario")
    private BigDecimal nPrecioUnitario;
}