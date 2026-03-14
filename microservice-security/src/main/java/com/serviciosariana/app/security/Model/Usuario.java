package com.serviciosariana.app.security.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    private Integer nUsuarioId;
    private Integer nPersonalId;
    private String cUsuario;
    private String cPassword;
    private Integer nIntentosFallidos;
    private LocalDateTime dFechaBloqueo;
    private LocalDateTime dFechaCreacion;
    private LocalDateTime dUltimoAcceso;
    private Boolean bPrimerAcceso;
    private Boolean bEstado;

    private Integer nCargoId;
    private String cCargoCod;
    private String cCargoNombre;
    private String cNombres;
    private String cApellidoPaterno;
    private String cApellidoMaterno;
    private String cNombreCompleto;
}