package com.serviciosariana.app.servicio.Model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CargaTrabajoDTO {
    private Integer nPersonalId;
    private String cNombreCompleto;
    private String cCargoNombre;
    private Integer nCargaComoLider;
    private Integer nCargaComoMiembro;
}