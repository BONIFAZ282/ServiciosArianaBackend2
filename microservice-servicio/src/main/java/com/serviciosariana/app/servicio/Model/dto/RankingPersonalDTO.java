package com.serviciosariana.app.servicio.Model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RankingPersonalDTO {
    private Integer nPersonalId;
    private String cNombreCompleto;
    private String cCargoNombre;
    private Integer nTotalComoLider;
    private Integer nCompletadasComoLider;
    private Integer nActivasComoLider;
    private Integer nTotalComoMiembro;
    private Integer nCompletadasComoMiembro;
    private Integer nActivasComoMiembro;
}