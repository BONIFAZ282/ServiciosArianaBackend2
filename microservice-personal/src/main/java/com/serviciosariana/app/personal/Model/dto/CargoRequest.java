package com.serviciosariana.app.personal.Model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CargoRequest {
    @JsonProperty("cCargoCod")
    @NotBlank(message = "El código es obligatorio")
    @Size(max = 20)
    private String cCargoCod;

    @JsonProperty("cNombre")
    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100)
    private String cNombre;

    @JsonProperty("cDescripcion")
    @Size(max = 250)
    private String cDescripcion;

    @JsonProperty("bEstado")
    private Boolean bEstado;
}