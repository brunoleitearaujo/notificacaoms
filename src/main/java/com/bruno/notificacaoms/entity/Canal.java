package com.bruno.notificacaoms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "tb_canal")
public class Canal {

    @Id
    private Long cdCanal;

    private String descricao;

    public Canal() {
    }

    public Canal(Long cdCanal, String descricao) {
        this.cdCanal = cdCanal;
        this.descricao = descricao;
    }

    public Long getCdCanal() {
        return cdCanal;
    }

    public void setCdCanal(Long cdCanal) {
        this.cdCanal = cdCanal;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Canal canal)) return false;
        return Objects.equals(cdCanal, canal.cdCanal) && Objects.equals(descricao, canal.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cdCanal, descricao);
    }

    public enum Values {
        EMAIL(1L, "Email"),
        SMS(2L, "Sms"),
        PUSH(3L, "Push"),
        WHATSAPP(4L, "Whatsapp"),
        ;

        private Long id;
        private String descricao;

        Values(Long id, String descricao) {
            this.id = id;
            this.descricao = descricao;
        }

        public Canal toCanal() {
            return new Canal(id, descricao);
        }
    }
}
