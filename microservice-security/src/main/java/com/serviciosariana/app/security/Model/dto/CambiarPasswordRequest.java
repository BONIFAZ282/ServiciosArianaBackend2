package com.serviciosariana.app.security.Model.dto;

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
public class CambiarPasswordRequest {

    @NotBlank(message = "La nueva contraseña es requerida")
    @Size(min = 6, max = 255, message = "La contraseña debe tener al menos 6 caracteres")
    @JsonProperty("cPassword")
    private String cPassword;
}