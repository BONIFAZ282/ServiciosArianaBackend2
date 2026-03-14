package com.serviciosariana.app.servicio.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrdenServicioDetalle {
    private Integer nOrdenServicioDetalleId;
    private Integer nOrdenServicioId;
    private Integer nTipoServicioId;
    private String cTipoServicioCod;
    private String cTipoServicioNombre;
    private String cDescripcion;
    private Integer nCantidad;
    private BigDecimal nPrecioUnitario;
    private BigDecimal nSubtotal;
    private Boolean bEstado;
}