package com.serviciosariana.app.security.Model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {

    @NotBlank(message = "El usuario es requerido")
    @JsonProperty("cUsuario")
    private String cUsuario;

    @NotBlank(message = "La contraseña es requerida")
    @JsonProperty("cPassword")
    private String cPassword;
}