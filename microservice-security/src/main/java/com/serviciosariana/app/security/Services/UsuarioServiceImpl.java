package com.serviciosariana.app.security.Services;

import com.serviciosariana.app.security.Model.Usuario;
import com.serviciosariana.app.security.Model.dto.BloqueoResponse;
import com.serviciosariana.app.security.Model.dto.IntentoFallidoResponse;
import com.serviciosariana.app.security.Model.dto.LoginResponse;
import com.serviciosariana.app.security.Model.dto.UsuarioListDTO;
import com.serviciosariana.app.security.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<UsuarioListDTO> listarTodos() {
        return usuarioRepository.listarTodos();
    }

    @Override
    public Optional<Usuario> obtenerPorId(Integer nUsuarioId) {
        return usuarioRepository.obtenerPorId(nUsuarioId);
    }

    @Override
    public Optional<Usuario> obtenerPorUsuario(String cUsuario) {
        return usuarioRepository.obtenerPorUsuario(cUsuario);
    }

    @Override
    public BloqueoResponse verificarBloqueo(String cUsuario) {
        return usuarioRepository.verificarBloqueo(cUsuario);
    }

    @Override
    public Integer crear(Integer nPersonalId, String cUsuario, String cPassword) {
        String passwordEncriptada = passwordEncoder.encode(cPassword);
        return usuarioRepository.insertar(nPersonalId, cUsuario, passwordEncriptada);
    }

    @Override
    public void cambiarPassword(Integer nUsuarioId, String cPassword) {
        String passwordEncriptada = passwordEncoder.encode(cPassword);
        usuarioRepository.actualizarPassword(nUsuarioId, passwordEncriptada);
    }

    @Override
    public void cambiarEstado(Integer nUsuarioId, Boolean bEstado) {
        usuarioRepository.actualizarEstado(nUsuarioId, bEstado);
    }

    @Override
    public void desbloquear(Integer nUsuarioId) {
        usuarioRepository.desbloquear(nUsuarioId);
    }

    @Override
    public IntentoFallidoResponse registrarIntentoFallido(String cUsuario) {
        return usuarioRepository.registrarIntentoFallido(cUsuario);
    }

    @Override
    public void registrarAccesoExitoso(Integer nUsuarioId) {
        usuarioRepository.actualizarUltimoAcceso(nUsuarioId);
    }

    @Override
    public LoginResponse login(String cUsuario, String cPassword) {
        BloqueoResponse bloqueo = usuarioRepository.verificarBloqueo(cUsuario);
        if (bloqueo.getBBloqueado()) {
            return LoginResponse.builder()
                    .bExitoso(false)
                    .cMensaje(bloqueo.getCMensaje())
                    .build();
        }

        Optional<Usuario> usuarioOpt = usuarioRepository.obtenerPorUsuario(cUsuario);

        if (usuarioOpt.isEmpty()) {
            return LoginResponse.builder()
                    .bExitoso(false)
                    .cMensaje("Usuario no encontrado")
                    .build();
        }

        Usuario usuario = usuarioOpt.get();

        if (!passwordEncoder.matches(cPassword, usuario.getCPassword())) {
            IntentoFallidoResponse intento = usuarioRepository.registrarIntentoFallido(cUsuario);

            String mensaje = intento.getBBloqueado()
                    ? "Cuenta bloqueada por " + intento.getNMinutosBloqueo() + " minutos"
                    : "Contraseña incorrecta. Intentos restantes: " + intento.getNIntentosRestantes();

            return LoginResponse.builder()
                    .bExitoso(false)
                    .cMensaje(mensaje)
                    .build();
        }

        usuarioRepository.actualizarUltimoAcceso(usuario.getNUsuarioId());

        return LoginResponse.builder()
                .bExitoso(true)
                .cMensaje("Login exitoso")
                .usuario(LoginResponse.Usuario.builder()
                        .nUsuarioId(usuario.getNUsuarioId())
                        .nPersonalId(usuario.getNPersonalId())
                        .cUsuario(usuario.getCUsuario())
                        .cNombreCompleto(usuario.getCNombreCompleto())
                        .nCargoId(usuario.getNCargoId())
                        .cCargoNombre(usuario.getCCargoNombre())
                        .bPrimerAcceso(usuario.getBPrimerAcceso())
                        .build())
                .build();
    }
}