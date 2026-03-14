package com.serviciosariana.app.security.Model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioCreateRequest {

    @JsonProperty("nPersonalId")
    @NotNull(message = "El ID del personal es requerido")
    private Integer nPersonalId;

    @JsonProperty("cUsuario")
    @NotBlank(message = "El usuario es requerido")
    @Size(max = 50)
    private String cUsuario;

    @JsonProperty("cPassword")
    @NotBlank(message = "La contraseña es requerida")
    @Size(min = 6, message = "La contraseña debe tener mínimo 6 caracteres")
    private String cPassword;
}