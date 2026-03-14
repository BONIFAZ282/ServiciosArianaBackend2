package com.serviciosariana.app.servicio.Model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonalDisponibleDTO {
    private Integer nPersonalId;
    private String cPersonalNombre;
    private String cCargoNombre;
    private String cTelefono;
}