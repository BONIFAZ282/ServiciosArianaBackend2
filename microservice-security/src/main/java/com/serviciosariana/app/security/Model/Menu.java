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
public class Menu {
    private Integer nMenuId;
    private String cMenuCod;
    private String cNombre;
    private String cDescripcion;
    private String cRuta;
    private String cIcono;
    private Integer nMenuPadreId;
    private String cMenuPadreNombre;
    private Integer nOrden;
    private LocalDateTime dFechaCreacion;
    private Boolean bEstado;
}