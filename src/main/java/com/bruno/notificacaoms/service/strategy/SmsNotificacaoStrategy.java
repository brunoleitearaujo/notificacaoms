package com.bruno.notificacaoms.service.strategy;

import com.bruno.notificacaoms.service.NotificacaoStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SmsNotificacaoStrategy implements NotificacaoStrategy {

    private static final Logger logger = LoggerFactory.getLogger(SmsNotificacaoStrategy.class);

    @Override
    public void enviarNotificacao(String destino, String mensagem) {
        logger.info("Notificação [{}] enviada para o Sms [{}]", mensagem, destino);
    }
}
