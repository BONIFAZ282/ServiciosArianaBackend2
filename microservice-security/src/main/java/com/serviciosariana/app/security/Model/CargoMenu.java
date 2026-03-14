package com.serviciosariana.app.security.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CargoMenu {
    private Integer nCargoMenuId;
    private Integer nCargoId;
    private Integer nMenuId;
    private String cMenuCod;
    private String cMenuNombre;
    private String cRuta;
    private String cIcono;
    private Integer nMenuPadreId;
    private String cMenuPadreNombre;
    private Integer nOrden;
    private Boolean bVer;
    private Boolean bCrear;
    private Boolean bEditar;
    private Boolean bEliminar;
    private Boolean bEstado;
}