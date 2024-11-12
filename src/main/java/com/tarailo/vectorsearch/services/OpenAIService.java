package com.tarailo.vectorsearch.services;

import com.tarailo.vectorsearch.models.EmbeddingResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.service.annotation.PostExchange;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;


public class OpenAIService {

    private static final String OPENAI_API_URI = "https://api.openai.com";

    @Value("${openai.api.key}")
    private String OPENAI_API_KEY;

    private WebClient webClient;

    @PostExchange
    void inti(){
        this.webClient = WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector())
                .baseUrl(OPENAI_API_URI)
                .defaultHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader("Authorization", "Bearer" + OPENAI_API_KEY)
                .build();
    }

    public Mono<List<Double>> createEmbedding(String text){
        Map<String, Object> body = Map.of(
                "model", "text-embedding-ada-002",
                "input", text
        );

        return webClient.post()
                .uri("/v1/embeddings")
                .bodyValue(body)
                .retrieve()
                .bodyToMono(EmbeddingResponse.class)
                .map(EmbeddingResponse::getEmbedding);
    }
}
