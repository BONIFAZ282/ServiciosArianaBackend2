package com.serviciosariana.app.servicio.Scheduler;

import com.serviciosariana.app.servicio.Services.AlertaService;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class AlertaScheduler {

    private static final Logger log = LoggerFactory.getLogger(AlertaScheduler.class);

    @Autowired
    private AlertaService alertaService;

    @PostConstruct
    public void init() {
        log.info("============================================");
        log.info("AlertaScheduler INICIADO - Tareas programadas activas");
        log.info("============================================");
    }
    /**
     * Genera alertas automáticas todos los días a las 6:00 AM
     * Cron: segundos minutos horas día-mes mes día-semana
     */
    //@Scheduled(cron = "0 * * * * ?")
    @Scheduled(cron = "0 0 6 * * ?")
    public void procesarAlertasYNotificaciones() {
        String fechaHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        log.info("========================================");
        log.info("INICIO - Proceso de alertas y notificaciones: {}", fechaHora);

        try {
            // PASO 1: Generar alertas automáticas
            log.info("Paso 1: Generando alertas automáticas...");
            Integer alertasGeneradas = alertaService.generarAutomaticas();
            log.info("Alertas generadas: {}", alertasGeneradas);

            // PASO 2: Enviar notificaciones por correo
            log.info("Paso 2: Enviando notificaciones por correo...");
            Integer correosEnviados = alertaService.enviarNotificacionesPendientes();
            log.info("Correos enviados: {}", correosEnviados);

        } catch (Exception e) {
            log.error("Error en proceso de alertas: {}", e.getMessage());
        }

        log.info("FIN - Proceso de alertas y notificaciones");
        log.info("========================================");
    }

    /**
     * OPCIONAL: Para pruebas - Ejecuta cada 5 minutos
     * Descomentar solo para probar, luego comentar o eliminar
     */
    // @Scheduled(fixedRate = 300000) // 5 minutos = 300,000 ms
    // public void generarAlertasPrueba() {
    //     log.info("PRUEBA - Ejecutando generación de alertas...");
    //     Integer alertasGeneradas = alertaService.generarAutomaticas();
    //     log.info("PRUEBA - Alertas generadas: {}", alertasGeneradas);
    // }
}