package com.serviciosariana.app.servicio.Model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AsignarPersonalRequest {
    @JsonProperty("nOrdenServicioId")
    private Integer nOrdenServicioId;

    @JsonProperty("nPersonalId")
    private Integer nPersonalId;

    @JsonProperty("cObservaciones")
    private String cObservaciones;
}