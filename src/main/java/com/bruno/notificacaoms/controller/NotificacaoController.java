package com.bruno.notificacaoms.controller;

import com.bruno.notificacaoms.controller.dto.AgendarNotificacaoDto;
import com.bruno.notificacaoms.entity.Notificacao;
import com.bruno.notificacaoms.service.NotificacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notificacao")
public class NotificacaoController {

    @Autowired
    private NotificacaoService service;

    @PostMapping
    public ResponseEntity<Void> agendarNotificacao(@RequestBody AgendarNotificacaoDto dto) {
        service.agendarNotificacao(dto);

        return ResponseEntity.accepted().build();
    }

    @GetMapping("/{cdNotificacao}")
    public ResponseEntity<Notificacao> buscarNotificacao(@PathVariable Long cdNotificacao) {
        var notificacao = service.findById(cdNotificacao);

        return notificacao.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }

    @PatchMapping("/{cdNotificacao}")
    public ResponseEntity<Void> cancelarNotificacao(@PathVariable Long cdNotificacao) {
        service.cancelarNotificacao(cdNotificacao);
        return ResponseEntity.noContent().build();
    }
}
