package com.serviciosariana.app.security.Repository.Translator;

import com.serviciosariana.app.security.Model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioTranslator {
    private Integer nUsuarioId;
    private Integer nPersonalId;
    private String cUsuario;
    private String cPassword;
    private Integer nIntentosFallidos;
    private LocalDateTime dFechaBloqueo;
    private LocalDateTime dFechaCreacion;
    private LocalDateTime dUltimoAcceso;
    private Boolean bPrimerAcceso;
    private Boolean bEstado;

    private Integer nCargoId;
    private String cCargoCod;
    private String cCargoNombre;
    private String cNombres;
    private String cApellidoPaterno;
    private String cApellidoMaterno;
    private String cNombreCompleto;

    public Usuario toUsuario() {
        return Usuario.builder()
                .nUsuarioId(this.nUsuarioId)
                .nPersonalId(this.nPersonalId)
                .cUsuario(this.cUsuario)
                .cPassword(this.cPassword)
                .nIntentosFallidos(this.nIntentosFallidos)
                .dFechaBloqueo(this.dFechaBloqueo)
                .dFechaCreacion(this.dFechaCreacion)
                .dUltimoAcceso(this.dUltimoAcceso)
                .bPrimerAcceso(this.bPrimerAcceso)
                .bEstado(this.bEstado)
                .nCargoId(this.nCargoId)
                .cCargoCod(this.cCargoCod)
                .cCargoNombre(this.cCargoNombre)
                .cNombres(this.cNombres)
                .cApellidoPaterno(this.cApellidoPaterno)
                .cApellidoMaterno(this.cApellidoMaterno)
                .cNombreCompleto(this.cNombreCompleto)
                .build();
    }
}