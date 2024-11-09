package com.bruno.notificacaoms.service.strategy;

import com.bruno.notificacaoms.service.NotificacaoStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WhatsappNotificacaoStrategy implements NotificacaoStrategy {

    private static final Logger logger = LoggerFactory.getLogger(WhatsappNotificacaoStrategy.class);

    @Override
    public void enviarNotificacao(String destino, String mensagem) {
        logger.info("Notificação [{}] enviada para o Whatsapp [{}]", mensagem, destino);
    }
}
