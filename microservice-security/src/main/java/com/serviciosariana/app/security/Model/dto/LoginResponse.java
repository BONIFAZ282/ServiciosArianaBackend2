package com.serviciosariana.app.security.Model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {
    private Boolean bExitoso;
    private String cMensaje;
    private Usuario usuario;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Usuario {
        private Integer nUsuarioId;
        private Integer nPersonalId;
        private String cUsuario;
        private String cNombreCompleto;
        private Integer nCargoId;
        private String cCargoNombre;
        private Boolean bPrimerAcceso;
    }
}