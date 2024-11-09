package com.bruno.notificacaoms.service;

public interface NotificacaoStrategy {

    void enviarNotificacao(String destino, String mensagem);
}
