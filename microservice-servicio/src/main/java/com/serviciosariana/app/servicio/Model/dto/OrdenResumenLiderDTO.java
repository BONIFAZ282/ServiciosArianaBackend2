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
public class OrdenResumenLiderDTO {
    private Integer nOrdenServicioId;
    private String cOrdenServicioCod;
    private String cTitulo;
    private String cClienteNombre;
    private String cEstadoOrdenNombre;
    private String cEstadoOrdenColor;
    private String cPrioridadNombre;
    private String cPrioridadColor;
    private LocalDate dFechaInicio;
    private LocalDate dFechaFin;
    private Integer nTotalTrabajadores;
    private Integer nTotalServicios;
}