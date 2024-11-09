package com.bruno.notificacaoms.service;

import com.bruno.notificacaoms.controller.dto.AgendarNotificacaoDto;
import com.bruno.notificacaoms.entity.Canal;
import com.bruno.notificacaoms.entity.Notificacao;
import com.bruno.notificacaoms.entity.Status;
import com.bruno.notificacaoms.repository.NotificacaoRepository;
import com.bruno.notificacaoms.service.strategy.EmailNotificacaoStrategy;
import com.bruno.notificacaoms.service.strategy.SmsNotificacaoStrategy;
import com.bruno.notificacaoms.service.strategy.WhatsappNotificacaoStrategy;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;

@Service
public class NotificacaoService {

    @Autowired
    private NotificacaoRepository repository;

    public void agendarNotificacao(AgendarNotificacaoDto dto) {
        repository.save(dto.toNotificacao());
    }

    public Optional<Notificacao> findById(Long cdNotificacao) {
        return repository.findById(cdNotificacao);
    }

    @Transactional
    public void cancelarNotificacao(Long cdNotificacao) {
        repository.cancelarNotificacao(cdNotificacao);
    }

    public void enviarNotificacao(LocalDateTime dateTime) {
        var notificacoes = repository.findByStatusInAndDateTimeBefore(
                List.of(Status.Values.PENDENTE.toStatus(), Status.Values.ERRO.toStatus()),
                dateTime
        );

        notificacoes.forEach(enviar());
    }

    private Consumer<Notificacao> enviar() {
        final Map<Canal, NotificacaoStrategy> mapStrategy = Map.of(
                Canal.Values.EMAIL.toCanal(), new EmailNotificacaoStrategy(),
                Canal.Values.SMS.toCanal(), new SmsNotificacaoStrategy(),
                Canal.Values.WHATSAPP.toCanal(), new WhatsappNotificacaoStrategy()
        );

        return n -> {mapStrategy.get(n.getCanal())
            .enviarNotificacao(n.getDestino(), n.getMensagem());
            n.setStatus(Status.Values.SUCESSO.toStatus());
            repository.save(n);
        };
    }
}
