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
public class OrdenServicioHistorial {
    private Integer nOrdenServicioHistorialId;
    private String cEstadoAnterior;
    private String cEstadoAnteriorColor;
    private String cEstadoNuevo;
    private String cEstadoNuevoColor;
    private String cComentario;
    private LocalDateTime dFechaCambio;
    private String cUsuarioNombre;
}