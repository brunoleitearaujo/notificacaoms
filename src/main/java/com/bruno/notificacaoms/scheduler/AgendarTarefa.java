package com.bruno.notificacaoms.scheduler;

import com.bruno.notificacaoms.service.NotificacaoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Component
public class AgendarTarefa {

    private static final Logger logger = LoggerFactory.getLogger(AgendarTarefa.class);

    @Autowired
    private NotificacaoService service;

    @Scheduled(fixedDelay = 1, timeUnit = TimeUnit.MINUTES)
    public void runTarefas() {
        var dateTime = LocalDateTime.now();
        logger.info("Running at {}", dateTime);
        service.enviarNotificacao(dateTime);
    }
}
