package com.bruno.notificacaoms.controller.dto;

import com.bruno.notificacaoms.entity.Canal;
import com.bruno.notificacaoms.entity.Notificacao;
import com.bruno.notificacaoms.entity.Status;

import java.time.LocalDateTime;

public record AgendarNotificacaoDto(LocalDateTime dateTime,
                                    String destino,
                                    String mensagem,
                                    Canal.Values canal) {

    public Notificacao toNotificacao() {
        return new Notificacao(
            dateTime,
            destino,
            mensagem,
            canal.toCanal(),
            Status.Values.PENDENTE.toStatus()
        );
    }
}
