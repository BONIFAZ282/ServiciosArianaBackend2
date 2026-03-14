package com.serviciosariana.app.security.Model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PermisosRequest {
    private Boolean bVer;
    private Boolean bCrear;
    private Boolean bEditar;
    private Boolean bEliminar;
    private Boolean bEstado;
}