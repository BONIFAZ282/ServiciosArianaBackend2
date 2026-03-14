package com.serviciosariana.app.servicio.Model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MarcarLeidaRequest {
    @JsonProperty("nUsuarioId")
    private Integer nUsuarioId;
}