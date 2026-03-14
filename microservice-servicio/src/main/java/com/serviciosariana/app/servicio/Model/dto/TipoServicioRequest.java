package com.serviciosariana.app.servicio.Model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoServicioRequest {
    @JsonProperty("cTipoServicioCod")
    @NotBlank(message = "El código es obligatorio")
    @Size(max = 20)
    private String cTipoServicioCod;

    @JsonProperty("cNombre")
    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100)
    private String cNombre;

    @JsonProperty("cDescripcion")
    @Size(max = 250)
    private String cDescripcion;

    @JsonProperty("nPrecioBase")
    @NotNull(message = "El precio base es obligatorio")
    private BigDecimal nPrecioBase;

    @JsonProperty("bEstado")
    private Boolean bEstado;
}