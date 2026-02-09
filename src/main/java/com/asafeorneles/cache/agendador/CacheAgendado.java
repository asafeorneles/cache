package com.asafeorneles.cache.agendador;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Component // Faz com que essa classe seja um componente do Spring. (@Service funciona, mas não vai ter regra de negócio.)
@Slf4j
public class CacheAgendado {

    @Scheduled(fixedDelay =  12, timeUnit = TimeUnit.SECONDS)
    @CacheEvict("empresas")
    public void clearCacheByTime(){
        log.info("Limpando o cache de empresas {}", LocalDateTime.now());
    }
}
