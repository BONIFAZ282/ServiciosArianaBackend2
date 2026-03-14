package com.serviciosariana.app.personal.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Personal {
    private Integer nPersonalId;
    private Integer nPersonaId;
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
    private Integer nTipoDocumentoId;
    private String cTipoDocCod;
    private Integer nCargoId;
    private String cCargoCod;
    private String cCargoNombre;
    private Integer nPersonalLiderId;
    private String cLiderNombre;
    private LocalDate dFechaIngreso;
    private LocalDate dFechaCese;
    private BigDecimal nSueldo;
    private String cObservaciones;
    private LocalDateTime dFechaCreacion;
    private Boolean bEstado;
}