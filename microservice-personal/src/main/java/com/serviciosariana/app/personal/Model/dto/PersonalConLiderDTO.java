package com.serviciosariana.app.personal.Model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonalConLiderDTO {
    private Integer nPersonalId;
    private String cNombreCompleto;
    private Integer nCargoId;
    private String cCargoNombre;
    private String cTelefono;
    private Integer nPersonalLiderId;
    private String cLiderNombre;
}