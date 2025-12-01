package com.ada.aula_todo_list.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    //registra um WebClient bean com base URL para dummyjson.com, reutilizável em serviços.
    @Bean
    public WebClient webClient() {
        return WebClient.builder().baseUrl("https://dummyjson.com").build();
    }
}
