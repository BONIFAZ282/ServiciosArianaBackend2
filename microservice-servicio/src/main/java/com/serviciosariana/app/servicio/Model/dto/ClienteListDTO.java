package com.serviciosariana.app.servicio.Model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteListDTO {
    private Integer nClienteId;
    private String cClienteCod;
    private String cTipoDocCod;
    private String cNumeroDocumento;
    private String cNombres;
    private String cApellidoPaterno;
    private String cApellidoMaterno;
    private String cRazonSocial;
    private String cNombreComercial;
    private String cNombreMostrar;
    private String cTelefono;
    private String cEmail;
    private String cDireccion;
    private LocalDateTime dFechaRegistro;
    private Boolean bEstado;
}