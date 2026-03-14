package com.serviciosariana.app.servicio.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Prioridad {
    private Integer nPrioridadId;
    private String cPrioridadCod;
    private String cNombre;
    private Integer nDiasAlerta;
    private String cColor;
    private Integer nOrden;
}