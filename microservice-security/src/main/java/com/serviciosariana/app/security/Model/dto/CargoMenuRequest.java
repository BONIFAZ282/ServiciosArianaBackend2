package com.serviciosariana.app.security.Model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CargoMenuRequest {
    @NotNull(message = "El cargo es obligatorio")
    private Integer nCargoId;

    @NotNull(message = "El menú es obligatorio")
    private Integer nMenuId;

    private Boolean bVer;
    private Boolean bCrear;
    private Boolean bEditar;
    private Boolean bEliminar;
}