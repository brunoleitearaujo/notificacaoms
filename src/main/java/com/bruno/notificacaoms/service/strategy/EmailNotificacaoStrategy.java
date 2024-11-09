package com.bruno.notificacaoms.service.strategy;

import com.bruno.notificacaoms.service.NotificacaoStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmailNotificacaoStrategy implements NotificacaoStrategy {

    private static final Logger logger = LoggerFactory.getLogger(EmailNotificacaoStrategy.class);

    @Override
    public void enviarNotificacao(String destino, String mensagem) {
        logger.info("Notificação [{}] enviada para o Email [{}]", mensagem, destino);
    }
}
