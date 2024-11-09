package com.bruno.notificacaoms.repository;

import com.bruno.notificacaoms.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRespository extends JpaRepository<Status, Long> {
}
