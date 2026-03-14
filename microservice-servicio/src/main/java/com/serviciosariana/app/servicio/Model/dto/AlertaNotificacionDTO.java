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
public class AlertaNotificacionDTO {
    private Integer nAlertaId;
    private Integer nOrdenServicioId;
    private String cOrdenServicioCod;
    private String cOrdenTitulo;
    private String cTipoAlertaCod;
    private String cTipoAlertaNombre;
    private String cMensaje;
    private LocalDateTime dFechaGeneracion;
    private LocalDate dFechaFin;
    private Integer nDias;
    private Integer nPersonalLiderId;
    private String cPersonalLiderNombre;
    private String cPersonalLiderEmail;
    private String cPrioridadNombre;
    private String cClienteNombre;
}