package com.serviciosariana.app.security.Model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BloqueoResponse {
    private Boolean bBloqueado;
    private String cMensaje;
    private LocalDateTime dFechaDesbloqueo;
}