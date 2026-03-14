package com.serviciosariana.app.security.Model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenuSidebarDTO {
    private Integer nMenuId;
    private String cMenuCod;
    private String cNombre;
    private String cRuta;
    private String cIcono;
    private Integer nMenuPadreId;
    private Integer nOrden;
    private Boolean bVer;
    private Boolean bCrear;
    private Boolean bEditar;
    private Boolean bEliminar;
}