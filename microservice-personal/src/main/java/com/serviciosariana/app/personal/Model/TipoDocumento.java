package com.serviciosariana.app.personal.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoDocumento {
    private Integer nTipoDocumentoId;
    private String cTipoDocCod;
    private String cNombre;
    private String cDescripcion;
    private Integer nLongitud;
    private Boolean bEstado;
}