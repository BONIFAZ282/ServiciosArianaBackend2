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
public class UsuarioListDTO {
    private Integer nUsuarioId;
    private Integer nPersonalId;
    private String cUsuario;
    private Integer nIntentosFallidos;
    private LocalDateTime dFechaBloqueo;
    private LocalDateTime dFechaCreacion;
    private LocalDateTime dUltimoAcceso;
    private Boolean bPrimerAcceso;
    private Boolean bEstado;
    private String cNombreCompleto;
    private String cCargoNombre;
}