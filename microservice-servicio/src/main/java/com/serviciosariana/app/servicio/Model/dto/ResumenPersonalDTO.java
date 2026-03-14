package com.serviciosariana.app.servicio.Model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResumenPersonalDTO {
    private Integer nPersonalId;
    private Integer nOrdenesComoLider;
    private Integer nOrdenesCompletadasComoLider;
    private Integer nOrdenesComoMiembro;
    private Integer nOrdenesActivasComoLider;
    private Integer nOrdenesActivasComoMiembro;
    private Integer nSubordinados;
}