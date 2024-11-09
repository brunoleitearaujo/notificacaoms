package com.bruno.notificacaoms.config;

import com.bruno.notificacaoms.entity.Canal;
import com.bruno.notificacaoms.entity.Status;
import com.bruno.notificacaoms.repository.CanalRepository;
import com.bruno.notificacaoms.repository.StatusRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DataLoader implements CommandLineRunner {

    @Autowired
    private CanalRepository canalRepository;

    @Autowired
    private StatusRespository statusRespository;

    @Override
    public void run(String... args) throws Exception {
        Arrays.stream(Canal.Values.values())
                .map(Canal.Values::toCanal)
                .forEach(canalRepository::save);

        Arrays.stream(Status.Values.values())
                .map(Status.Values::toStatus)
                .forEach(statusRespository::save);
    }
}
