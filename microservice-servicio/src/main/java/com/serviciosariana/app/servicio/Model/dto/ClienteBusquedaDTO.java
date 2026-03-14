package com.serviciosariana.app.servicio.Model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteBusquedaDTO {
    private Integer nClienteId;
    private String cClienteCod;
    private String cNumeroDocumento;
    private String cNombreCompleto;
    private String cTelefono;
    private String cEmail;
    private Boolean bEncontrado;
}