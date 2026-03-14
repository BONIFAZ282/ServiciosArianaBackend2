package com.serviciosariana.app.servicio.Services;

import com.serviciosariana.app.servicio.Model.dto.AlertaNotificacionDTO;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;

@Service
public class EmailServiceImpl implements EmailService {

    private static final Logger log = LoggerFactory.getLogger(EmailServiceImpl.class);

    @Autowired
    private JavaMailSender mailSender;

    @Value("${app.mail.from:noreply@serviciosariana.com}")
    private String fromEmail;

    @Value("${app.mail.enabled:false}")
    private boolean emailEnabled;

    @Override
    public boolean enviarAlertaEmail(AlertaNotificacionDTO alerta) {
        if (!emailEnabled) {
            log.info("Envío de email deshabilitado. Alerta {} no notificada.", alerta.getNAlertaId());
            return false;
        }

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setFrom(fromEmail);
            helper.setTo(alerta.getCPersonalLiderEmail());
            helper.setSubject(generarAsunto(alerta));
            helper.setText(generarCuerpoHtml(alerta), true);

            mailSender.send(message);
            log.info("Email enviado exitosamente a: {} para alerta: {}",
                    alerta.getCPersonalLiderEmail(), alerta.getNAlertaId());
            return true;

        } catch (MessagingException e) {
            log.error("Error al enviar email para alerta {}: {}", alerta.getNAlertaId(), e.getMessage());
            return false;
        }
    }

    private String generarAsunto(AlertaNotificacionDTO alerta) {
        if ("VENCIDO".equals(alerta.getCTipoAlertaCod())) {
            return "⚠️ URGENTE: Orden " + alerta.getCOrdenServicioCod() + " VENCIDA";
        } else {
            return "⏰ Aviso: Orden " + alerta.getCOrdenServicioCod() + " próxima a vencer";
        }
    }

    private String generarCuerpoHtml(AlertaNotificacionDTO alerta) {
        String colorAlerta = "VENCIDO".equals(alerta.getCTipoAlertaCod()) ? "#DC3545" : "#FFC107";
        String tipoMensaje = "VENCIDO".equals(alerta.getCTipoAlertaCod())
                ? "ha vencido hace " + alerta.getNDias() + " días"
                : "vence en " + alerta.getNDias() + " días";

        return """
            <!DOCTYPE html>
            <html>
            <head>
                <meta charset="UTF-8">
                <style>
                    body { font-family: Arial, sans-serif; line-height: 1.6; color: #333; }
                    .container { max-width: 600px; margin: 0 auto; padding: 20px; }
                    .header { background-color: %s; color: white; padding: 20px; text-align: center; border-radius: 8px 8px 0 0; }
                    .content { background-color: #f9f9f9; padding: 20px; border: 1px solid #ddd; }
                    .detail-row { padding: 10px 0; border-bottom: 1px solid #eee; }
                    .label { font-weight: bold; color: #555; }
                    .footer { background-color: #333; color: white; padding: 15px; text-align: center; border-radius: 0 0 8px 8px; font-size: 12px; }
                    .btn { display: inline-block; padding: 10px 20px; background-color: #007bff; color: white; text-decoration: none; border-radius: 5px; margin-top: 15px; }
                </style>
            </head>
            <body>
                <div class="container">
                    <div class="header">
                        <h2>%s</h2>
                        <p>La orden %s</p>
                    </div>
                    <div class="content">
                        <div class="detail-row">
                            <span class="label">Código de Orden:</span> %s
                        </div>
                        <div class="detail-row">
                            <span class="label">Título:</span> %s
                        </div>
                        <div class="detail-row">
                            <span class="label">Cliente:</span> %s
                        </div>
                        <div class="detail-row">
                            <span class="label">Prioridad:</span> %s
                        </div>
                        <div class="detail-row">
                            <span class="label">Fecha Límite:</span> %s
                        </div>
                        <div class="detail-row">
                            <span class="label">Responsable:</span> %s
                        </div>
                        <p style="margin-top: 20px;">
                            Por favor, tome las acciones necesarias para resolver esta orden de servicio.
                        </p>
                    </div>
                    <div class="footer">
                        <p>Multiservicios Ariana - Sistema de Gestión de Servicios</p>
                        <p>Este es un correo automático, por favor no responda.</p>
                    </div>
                </div>
            </body>
            </html>
            """.formatted(
                colorAlerta,
                alerta.getCTipoAlertaNombre().toUpperCase(),
                tipoMensaje,
                alerta.getCOrdenServicioCod(),
                alerta.getCOrdenTitulo(),
                alerta.getCClienteNombre(),
                alerta.getCPrioridadNombre(),
                alerta.getDFechaFin().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                alerta.getCPersonalLiderNombre()
        );
    }
}