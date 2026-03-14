package com.serviciosariana.app.servicio.Model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRequest {

    @JsonProperty("nTipoDocumentoId")
    @NotNull(message = "El tipo de documento es obligatorio")
    private Integer nTipoDocumentoId;

    @JsonProperty("cNumeroDocumento")
    @NotBlank(message = "El número de documento es obligatorio")
    @Size(max = 20)
    private String cNumeroDocumento;

    @JsonProperty("cNombres")
    @Size(max = 100)
    private String cNombres;

    @JsonProperty("cApellidoPaterno")
    @Size(max = 100)
    private String cApellidoPaterno;

    @JsonProperty("cApellidoMaterno")
    @Size(max = 100)
    private String cApellidoMaterno;

    @JsonProperty("cSexo")
    @Size(max = 1)
    private String cSexo;

    @JsonProperty("dFechaNacimiento")
    private LocalDate dFechaNacimiento;

    @JsonProperty("cTelefono")
    @Size(max = 20)
    private String cTelefono;

    @JsonProperty("cEmail")
    @Size(max = 100)
    private String cEmail;

    @JsonProperty("cDireccion")
    @Size(max = 250)
    private String cDireccion;

    @JsonProperty("cRazonSocial")
    @Size(max = 200)
    private String cRazonSocial;

    @JsonProperty("cNombreComercial")
    @Size(max = 200)
    private String cNombreComercial;

    @JsonProperty("cObservaciones")
    @Size(max = 500)
    private String cObservaciones;

    @JsonProperty("bEstado")
    private Boolean bEstado;
}