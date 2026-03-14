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
public class Actividad {
    private Integer nActividadId;
    private Integer nOrdenServicioId;
    private String cOrdenServicioCod;
    private String cOrdenTitulo;
    private Integer nPersonalId;
    private String cPersonalNombre;
    private String cCargoNombre;
    private String cTitulo;
    private String cDescripcion;
    private LocalDate dFechaActividad;
    private LocalDateTime dFechaCreacion;
    private Integer nTotalEvidencias;
    private Boolean bEstado;
}