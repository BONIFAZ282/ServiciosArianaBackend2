package com.serviciosariana.app.servicio.Model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class OrdenServicioRequest {
    @JsonProperty("nClienteId")
    private Integer nClienteId;

    @JsonProperty("nTipoServicioId")
    private Integer nTipoServicioId;

    @JsonProperty("nPrioridadId")
    private Integer nPrioridadId;

    @JsonProperty("cTitulo")
    private String cTitulo;

    @JsonProperty("cDescripcion")
    private String cDescripcion;

    @JsonProperty("dFechaInicio")
    private LocalDate dFechaInicio;

    @JsonProperty("dFechaFin")
    private LocalDate dFechaFin;

    @JsonProperty("nPersonalLiderId")
    private Integer nPersonalLiderId;

    @JsonProperty("cDireccionServicio")
    private String cDireccionServicio;

    @JsonProperty("nCostoEstimado")
    private BigDecimal nCostoEstimado;

    @JsonProperty("nCostoReal")
    private BigDecimal nCostoReal;

    @JsonProperty("cObservaciones")
    private String cObservaciones;

    @JsonProperty("nUsuarioCreacionId")
    private Integer nUsuarioCreacionId;
}