package com.timetobeat.timetobeat.config;

import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;

@Configuration
public class ExternalApiConfig {
    private static final String BASE_URL = "https://api.igdb.com/v4/";
    @Value("${client_id}")
    private String clientId;
    @Value("${access_token}")
    private String accessToken;
    @Bean
    public WebClient webClientWithTimeout() {
        HttpClient httpClient = HttpClient.create()
                .responseTimeout(Duration.ofSeconds(2))
                .doOnConnected(conn -> conn
                        .addHandlerLast(new ReadTimeoutHandler(10))
                        .addHandlerLast(new WriteTimeoutHandler(10)));

        return WebClient.builder()
                .baseUrl(BASE_URL)
                .defaultHeaders(httpHeaders -> {
                    httpHeaders.set("Client-ID", clientId);
                    httpHeaders.set("Authorization", "Bearer " + accessToken);
                })
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();
    }
}
