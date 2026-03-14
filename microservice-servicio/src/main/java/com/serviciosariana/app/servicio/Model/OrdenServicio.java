package com.serviciosariana.app.servicio.Model;

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
public class OrdenServicio {
    private Integer nOrdenServicioId;
    private String cOrdenServicioCod;
    private Integer nClienteId;
    private String cClienteCod;
    private String cClienteNombre;
    private String cClienteDocumento;
    private String cClienteTelefono;
    private String cClienteEmail;
    private Integer nTipoServicioId;
    private String cTipoServicioCod;
    private String cTipoServicioNombre;
    private Integer nPrioridadId;
    private String cPrioridadCod;
    private String cPrioridadNombre;
    private String cPrioridadColor;
    private Integer nEstadoOrdenId;
    private String cEstadoOrdenCod;
    private String cEstadoOrdenNombre;
    private String cEstadoOrdenColor;
    private Boolean bPermiteEditar;
    private String cTitulo;
    private String cDescripcion;
    private LocalDate dFechaInicio;
    private LocalDate dFechaFin;
    private LocalDate dFechaFinReal;
    private Integer nPersonalLiderId;
    private String cPersonalLiderNombre;
    private String cDireccionServicio;
    private BigDecimal nCostoEstimado;
    private BigDecimal nCostoReal;
    private String cObservaciones;
    private LocalDateTime dFechaCreacion;
    private Integer nUsuarioCreacionId;
    private Boolean bEstado;
    private Integer nTrabajadoresAsignados;
}