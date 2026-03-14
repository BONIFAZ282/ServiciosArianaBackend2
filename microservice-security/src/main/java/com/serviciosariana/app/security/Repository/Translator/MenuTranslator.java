package com.serviciosariana.app.security.Repository.Translator;

import com.serviciosariana.app.security.Model.Menu;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenuTranslator {
    private Integer nMenuId;
    private String cMenuCod;
    private String cNombre;
    private String cDescripcion;
    private String cRuta;
    private String cIcono;
    private Integer nMenuPadreId;
    private String cMenuPadreNombre;
    private Integer nOrden;
    private LocalDateTime dFechaCreacion;
    private Boolean bEstado;

    public Menu toMenu() {
        return Menu.builder()
                .nMenuId(this.nMenuId)
                .cMenuCod(this.cMenuCod)
                .cNombre(this.cNombre)
                .cDescripcion(this.cDescripcion)
                .cRuta(this.cRuta)
                .cIcono(this.cIcono)
                .nMenuPadreId(this.nMenuPadreId)
                .cMenuPadreNombre(this.cMenuPadreNombre)
                .nOrden(this.nOrden)
                .dFechaCreacion(this.dFechaCreacion)
                .bEstado(this.bEstado)
                .build();
    }
}