package com.serviciosariana.app.security.Services;


import com.serviciosariana.app.security.Model.Usuario;
import com.serviciosariana.app.security.Model.dto.BloqueoResponse;
import com.serviciosariana.app.security.Model.dto.IntentoFallidoResponse;
import com.serviciosariana.app.security.Model.dto.LoginResponse;
import com.serviciosariana.app.security.Model.dto.UsuarioListDTO;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    List<UsuarioListDTO> listarTodos();

    Optional<Usuario> obtenerPorId(Integer nUsuarioId);
    Optional<Usuario> obtenerPorUsuario(String cUsuario);
    BloqueoResponse verificarBloqueo(String cUsuario);

    Integer crear(Integer nPersonalId, String cUsuario, String cPassword);

    void cambiarPassword(Integer nUsuarioId, String cPassword);
    void cambiarEstado(Integer nUsuarioId, Boolean bEstado);
    void desbloquear(Integer nUsuarioId);
    IntentoFallidoResponse registrarIntentoFallido(String cUsuario);
    void registrarAccesoExitoso(Integer nUsuarioId);

    LoginResponse login(String cUsuario, String cPassword);
}