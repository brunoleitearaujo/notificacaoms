package com.bruno.notificacaoms.repository;

import com.bruno.notificacaoms.entity.Notificacao;
import com.bruno.notificacaoms.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface NotificacaoRepository extends JpaRepository<Notificacao, Long> {

    @Modifying
    @Query("UPDATE Notificacao n SET n.status.cdStatus = 4 WHERE n.cdNotificacao =:cdNotificacao")
    void cancelarNotificacao(@Param("cdNotificacao") Long cdNotificacao);

    List<Notificacao> findByStatusInAndDateTimeBefore(List<Status> status, LocalDateTime dateTime);
}
