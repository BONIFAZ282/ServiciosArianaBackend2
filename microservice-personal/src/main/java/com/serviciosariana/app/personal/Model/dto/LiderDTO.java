package com.serviciosariana.app.personal.Model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LiderDTO {
    private Integer nPersonalId;
    private String cNombreCompleto;
    private String cCargoNombre;
}