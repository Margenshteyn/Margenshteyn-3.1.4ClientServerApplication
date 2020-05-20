package com.example.SpringClient.web.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;



@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder
//                .setConnectTimeout(Duration.ofSeconds(2))
//                .setReadTimeout(Duration.ofSeconds(3))
                .rootUri("http://localhost:8081/api")
                .basicAuthentication("admin", "admin")
                .build();
    }
}
