package com.serviciosariana.app.security.Model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenuPadreDTO {
    private Integer nMenuId;
    private String cMenuCod;
    private String cNombre;
    private String cIcono;
    private Integer nOrden;
}