package com.serviciosariana.app.servicio.Model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EvidenciaRequest {
    @JsonProperty("cNombreArchivo")
    private String cNombreArchivo;

    @JsonProperty("cRutaArchivo")
    private String cRutaArchivo;

    @JsonProperty("cTipoArchivo")
    private String cTipoArchivo;

    @JsonProperty("nTamano")
    private Integer nTamano;
}