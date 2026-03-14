package com.serviciosariana.app.security.Model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IntentoFallidoResponse {
    private Boolean bBloqueado;
    private Integer nMinutosBloqueo;
    private Integer nIntentosRestantes;
}