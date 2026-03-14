package com.serviciosariana.app.servicio.Model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CambiarEstadoRequest {
    @JsonProperty("cEstadoOrdenCodNuevo")
    private String cEstadoOrdenCodNuevo;

    @JsonProperty("cComentario")
    private String cComentario;

    @JsonProperty("nUsuarioId")
    private Integer nUsuarioId;
}