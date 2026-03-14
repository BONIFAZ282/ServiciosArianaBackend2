package com.serviciosariana.app.servicio.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EstadoOrden {
    private Integer nEstadoOrdenId;
    private String cEstadoOrdenCod;
    private String cNombre;
    private String cDescripcion;
    private String cColor;
    private Integer nOrden;
    private Boolean bPermiteEditar;
}