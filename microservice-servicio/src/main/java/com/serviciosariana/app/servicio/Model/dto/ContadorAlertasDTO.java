package com.serviciosariana.app.servicio.Model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContadorAlertasDTO {
    private Integer nTotalNoLeidas;
    private Integer nPorVencer;
    private Integer nVencidas;
}