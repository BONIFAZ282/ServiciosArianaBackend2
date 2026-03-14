package com.serviciosariana.app.servicio.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    private Integer nClienteId;
    private String cClienteCod;
    private Integer nPersonaId;
    private Integer nTipoDocumentoId;
    private String cTipoDocCod;
    private String cTipoDocNombre;
    private String cNumeroDocumento;
    private String cNombres;
    private String cApellidoPaterno;
    private String cApellidoMaterno;
    private String cNombreCompleto;
    private String cSexo;
    private LocalDate dFechaNacimiento;
    private String cTelefono;
    private String cEmail;
    private String cDireccion;
    private String cRazonSocial;
    private String cNombreComercial;
    private String cNombreMostrar;
    private LocalDateTime dFechaRegistro;
    private String cObservaciones;
    private Boolean bEstado;
}