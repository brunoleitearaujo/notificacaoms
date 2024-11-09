package com.bruno.notificacaoms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_status")
public class Status {

    @Id
    private Long cdStatus;

    private String descricao;

    public Status() {
    }

    public Status(Long cdStatus, String descricao) {
        this.cdStatus = cdStatus;
        this.descricao = descricao;
    }

    public Long getCdStatus() {
        return cdStatus;
    }

    public void setCdStatus(Long cdStatus) {
        this.cdStatus = cdStatus;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public enum Values {
        PENDENTE(1L, "Pendente"),
        SUCESSO(2L, "Sucesso"),
        ERRO(3L, "Erro"),
        CANCELADO(4L, "Cancelado"),
        ;

        private Long id;
        private String descricao;

        Values(Long id, String descricao) {
            this.id = id;
            this.descricao = descricao;
        }

        public Status toStatus() {
            return new Status(id, descricao);
        }
    }
}
