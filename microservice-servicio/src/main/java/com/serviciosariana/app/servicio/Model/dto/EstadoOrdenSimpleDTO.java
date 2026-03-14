package com.serviciosariana.app.servicio.Model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EstadoOrdenSimpleDTO {
    private Integer nEstadoOrdenId;
    private String cEstadoOrdenCod;
    private String cNombre;
    private String cColor;
}