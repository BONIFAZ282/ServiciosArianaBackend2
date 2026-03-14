package com.serviciosariana.app.security.Model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenuRequest {
    @NotBlank(message = "El código es obligatorio")
    @Size(max = 20, message = "El código no puede exceder 20 caracteres")
    private String cMenuCod;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100, message = "El nombre no puede exceder 100 caracteres")
    private String cNombre;

    @Size(max = 250, message = "La descripción no puede exceder 250 caracteres")
    private String cDescripcion;

    @NotBlank(message = "La ruta es obligatoria")
    @Size(max = 200, message = "La ruta no puede exceder 200 caracteres")
    private String cRuta;

    @Size(max = 50, message = "El icono no puede exceder 50 caracteres")
    private String cIcono;

    private Integer nMenuPadreId;

    private Integer nOrden;

    private Boolean bEstado;
}