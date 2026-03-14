package com.serviciosariana.app.servicio.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoAlerta {
    private Integer nTipoAlertaId;
    private String cTipoAlertaCod;
    private String cNombre;
    private String cDescripcion;
    private String cColor;
}