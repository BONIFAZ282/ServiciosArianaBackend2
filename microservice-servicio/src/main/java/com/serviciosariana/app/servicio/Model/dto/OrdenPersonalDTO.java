package com.serviciosariana.app.servicio.Model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrdenPersonalDTO {
    private Integer nOrdenServicioId;
    private String cOrdenServicioCod;
    private String cTitulo;
    private String cClienteNombre;
    private String cEstadoOrdenCod;
    private String cEstadoNombre;
    private String cEstadoColor;
    private String cPrioridadNombre;
    private String cPrioridadColor;
    private LocalDate dFechaInicio;
    private LocalDate dFechaFin;
    private Integer nPersonalLiderId;
    private String cPersonalLiderNombre;
    private String cRol;
    private String cTipoServicioNombre;
}