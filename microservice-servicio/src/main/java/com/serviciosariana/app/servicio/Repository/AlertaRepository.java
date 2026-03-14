package com.serviciosariana.app.servicio.Repository;

import com.serviciosariana.app.servicio.Model.dto.AlertaDTO;
import com.serviciosariana.app.servicio.Model.dto.AlertaNotificacionDTO;
import com.serviciosariana.app.servicio.Model.dto.ContadorAlertasDTO;
import java.util.List;
import java.util.Optional;

public interface AlertaRepository {

    Integer generarAutomaticas();

    List<AlertaDTO> listarTodos(Integer nPersonalId, Boolean bSoloNoLeidas);

    ContadorAlertasDTO contadorNoLeidas(Integer nPersonalId);

    void marcarLeida(Integer nAlertaId, Integer nUsuarioId);

    Integer marcarTodasLeidas(Integer nPersonalId, Integer nUsuarioId);

    Optional<AlertaDTO> obtenerPorId(Integer nAlertaId);

    void marcarResuelta(Integer nAlertaId, Integer nUsuarioId);

    List<AlertaNotificacionDTO> listarPendientesNotificacion();

    void marcarNotificada(Integer nAlertaId);

}