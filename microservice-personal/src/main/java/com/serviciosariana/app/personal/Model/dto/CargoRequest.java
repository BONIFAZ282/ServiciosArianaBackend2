package com.serviciosariana.app.personal.Model.dto;

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
    @NotBlank(message = "El código es obligatorio")
    @Size(max = 20)
    private String cCargoCod;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100)
    private String cNombre;

    @Size(max = 250)
    private String cDescripcion;

    private Boolean bEstado;
}