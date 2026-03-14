package com.serviciosariana.app.servicio.Model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.time.LocalDate;

@Data
public class ActividadRequest {
    @JsonProperty("nOrdenServicioId")
    private Integer nOrdenServicioId;

    @JsonProperty("nPersonalId")
    private Integer nPersonalId;

    @JsonProperty("cTitulo")
    private String cTitulo;

    @JsonProperty("cDescripcion")
    private String cDescripcion;

    @JsonProperty("dFechaActividad")
    private LocalDate dFechaActividad;
}