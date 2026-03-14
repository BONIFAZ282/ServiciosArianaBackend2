package com.serviciosariana.app.servicio.Model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteComboDTO {
    private Integer nClienteId;
    private String cClienteCod;
    private String cNombreMostrar;
    private String cNumeroDocumento;
}