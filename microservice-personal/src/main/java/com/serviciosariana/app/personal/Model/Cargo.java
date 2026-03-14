package com.serviciosariana.app.personal.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cargo {
    private Integer nCargoId;
    private String cCargoCod;
    private String cNombre;
    private String cDescripcion;
    private LocalDateTime dFechaCreacion;
    private Boolean bEstado;
}