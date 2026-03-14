package com.serviciosariana.app.personal.Model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonalListDTO {
    private Integer nPersonalId;
    private Integer nPersonaId;
    private Integer nTipoDocumentoId;
    private String cTipoDocNombre;
    private String cNumeroDocumento;
    private String cNombres;
    private String cApellidoPaterno;
    private String cApellidoMaterno;
    private String cNombreCompleto;
    private LocalDate dFechaNacimiento;
    private String cTelefono;
    private String cEmail;
    private String cDireccion;
    private Integer nCargoId;
    private String cCargoCod;
    private String cCargoNombre;
    private Integer nPersonalLiderId;
    private String cLiderNombre;
    private LocalDate dFechaIngreso;
    private BigDecimal nSueldo;
    private Boolean bEstado;

    private Integer nUsuarioId;
    private String cUsuario;
    private Boolean bTieneUsuario;
}