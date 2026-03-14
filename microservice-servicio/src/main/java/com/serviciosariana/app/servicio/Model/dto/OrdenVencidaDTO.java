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
public class OrdenVencidaDTO {
    private Integer nOrdenServicioId;
    private String cOrdenServicioCod;
    private String cTitulo;
    private String cClienteNombre;
    private String cEstadoNombre;
    private String cEstadoColor;
    private String cPrioridadNombre;
    private String cPrioridadColor;
    private LocalDate dFechaFin;
    private Integer nDiasVencido;
    private String cLiderNombre;
}