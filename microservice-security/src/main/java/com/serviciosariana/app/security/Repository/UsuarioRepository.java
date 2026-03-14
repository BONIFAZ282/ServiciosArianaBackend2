package com.serviciosariana.app.security.Repository;



import com.serviciosariana.app.security.Model.Usuario;
import com.serviciosariana.app.security.Model.dto.BloqueoResponse;
import com.serviciosariana.app.security.Model.dto.IntentoFallidoResponse;
import com.serviciosariana.app.security.Model.dto.UsuarioListDTO;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository {

    List<UsuarioListDTO> listarTodos();

    Optional<Usuario> obtenerPorId(Integer nUsuarioId);
    Optional<Usuario> obtenerPorUsuario(String cUsuario);
    BloqueoResponse verificarBloqueo(String cUsuario);

    Integer insertar(Integer nPersonalId, String cUsuario, String cPassword);

    void actualizarPassword(Integer nUsuarioId, String cPassword);
    void actualizarEstado(Integer nUsuarioId, Boolean bEstado);
    void desbloquear(Integer nUsuarioId);
    IntentoFallidoResponse registrarIntentoFallido(String cUsuario);
    void actualizarUltimoAcceso(Integer nUsuarioId);
}