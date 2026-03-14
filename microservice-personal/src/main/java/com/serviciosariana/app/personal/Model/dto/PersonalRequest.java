package com.serviciosariana.app.personal.Model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonalRequest {
    @Valid
    @NotNull(message = "Los datos de persona son obligatorios")
    private PersonaRequest persona;

    @JsonProperty("nCargoId")
    @NotNull(message = "El cargo es obligatorio")
    private Integer nCargoId;

    @JsonProperty("nPersonalLiderId")
    private Integer nPersonalLiderId;

    @JsonProperty("dFechaIngreso")
    @NotNull(message = "La fecha de ingreso es obligatoria")
    private LocalDate dFechaIngreso;

    @JsonProperty("dFechaCese")
    private LocalDate dFechaCese;

    @JsonProperty("nSueldo")
    private BigDecimal nSueldo;

    @JsonProperty("cObservaciones")
    private String cObservaciones;

    @JsonProperty("bEstado")
    private Boolean bEstado;
}