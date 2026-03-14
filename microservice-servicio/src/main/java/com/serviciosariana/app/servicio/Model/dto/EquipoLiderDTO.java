package com.serviciosariana.app.servicio.Model.dto;

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
public class EquipoLiderDTO {
    private Integer nOrdenServicioId;
    private String cOrdenServicioCod;
    private String cTitulo;
    private String cEstadoOrdenNombre;
    private String cEstadoOrdenColor;
    private LocalDate dFechaInicio;
    private LocalDate dFechaFin;
    private Integer nTrabajadorId;
    private String cTrabajadorNombre;
    private String cTrabajadorCargo;
    private String cTrabajadorTelefono;
    private LocalDateTime dFechaAsignacion;
}