package com.example.demo.services;
import java.time.Duration;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ReactiveService {
    private final WebClient webclient;

    public ReactiveService() {
        this.webclient = WebClient.create("http://localhost:8080");
    }

    Mono<String> get() {
        return webclient.get().uri("/test").exchangeToMono(response -> {
            return response.bodyToMono(String.class);
        });

     }
}
