package com.serviciosariana.app.servicio.Services;

import com.serviciosariana.app.servicio.Model.dto.AlertaNotificacionDTO;

public interface EmailService {

    boolean enviarAlertaEmail(AlertaNotificacionDTO alerta);
}