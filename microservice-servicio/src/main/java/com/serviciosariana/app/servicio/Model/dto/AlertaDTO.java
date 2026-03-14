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
public class AlertaDTO {
    private Integer nAlertaId;
    private Integer nOrdenServicioId;
    private String cOrdenServicioCod;
    private String cOrdenTitulo;
    private String cClienteNombre;
    private Integer nTipoAlertaId;
    private String cTipoAlertaCod;
    private String cTipoAlertaNombre;
    private String cTipoAlertaColor;
    private String cMensaje;
    private LocalDateTime dFechaGeneracion;
    private Boolean bLeida;
    private LocalDateTime dFechaLectura;
    private Integer nPersonalLiderId;
    private String cPersonalLiderNombre;
    private LocalDate dFechaFin;
    private Integer nDiasVencido;
    private String cPrioridadNombre;
    private String cPrioridadColor;
    private String cEstadoOrdenNombre;
    private String cEstadoOrdenColor;
}