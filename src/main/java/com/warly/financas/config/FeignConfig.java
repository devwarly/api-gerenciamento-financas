package com.warly.financas.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    Logger.Level feignLoggerLevel() {
        // .FULL mostra Headers, Body e Metadados da requisição
        return Logger.Level.FULL;
    }
}