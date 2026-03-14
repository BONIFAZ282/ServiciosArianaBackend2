package com.serviciosariana.app.servicio.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActividadEvidencia {
    private Integer nActividadEvidenciaId;
    private Integer nActividadId;
    private String cNombreArchivo;
    private String cRutaArchivo;
    private String cTipoArchivo;
    private Integer nTamano;
    private LocalDateTime dFechaCreacion;
    private Boolean bEstado;
}