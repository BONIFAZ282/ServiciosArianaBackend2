package com.serviciosariana.app.servicio.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrdenServicioPersonal {
    private Integer nOrdenServicioPersonalId;
    private Integer nOrdenServicioId;
    private Integer nPersonalId;
    private String cPersonalNombre;
    private String cTelefono;
    private String cEmail;
    private String cCargoNombre;
    private LocalDateTime dFechaAsignacion;
    private LocalDateTime dFechaDesasignacion;
    private String cObservaciones;
    private Boolean bActivo;
}