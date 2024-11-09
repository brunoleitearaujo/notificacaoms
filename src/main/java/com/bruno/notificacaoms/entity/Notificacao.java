package com.bruno.notificacaoms.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_notificacao")
public class Notificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cdNotificacao;

    private LocalDateTime dateTime;

    private String destino;

    private String mensagem;

    @ManyToOne
    @JoinColumn(name = "cd_canal")
    private Canal canal;

    @ManyToOne
    @JoinColumn(name = "cd_status")
    private Status status;

    public Notificacao() {
    }

    public Notificacao(LocalDateTime dateTime, String destino, String mensagem, Canal canal, Status status) {
        this.dateTime = dateTime;
        this.destino = destino;
        this.mensagem = mensagem;
        this.canal = canal;
        this.status = status;
    }

    public Long getCdNotificacao() {
        return cdNotificacao;
    }

    public void setCdNotificacao(Long cdNotificacao) {
        this.cdNotificacao = cdNotificacao;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Canal getCanal() {
        return canal;
    }

    public void setCanal(Canal canal) {
        this.canal = canal;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
