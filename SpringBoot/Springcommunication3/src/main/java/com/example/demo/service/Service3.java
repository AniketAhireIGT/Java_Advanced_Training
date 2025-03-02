package com.example.demo.service;

import java.net.URI;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import com.example.demo.model.Product;
import reactor.core.publisher.Mono;

@Service
public class Service3 {

    private final WebClient webClient;

    private static final String ROOT_URI = "http://localhost:9999/getProductS1";
    private static final String ROOT_URI2 = "http://localhost:9999/setProdS1";
    private static final String ROOT_URI3 = "http://localhost:9999/deleteProdS1";
    private static final String ROOT_URI4 = "http://localhost:9999/updateProdS1";

    public Service3(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:9999").build();
    }

    public List<Product> findAllMyModel() {
        return webClient.get()
                .uri("/getProductS1")
                .retrieve()
                .bodyToFlux(Product.class)
                .collectList()
                .block(); // Blocking to return List<Product>
    }

    public Product FindModelbyId(int id) {
        return webClient.get()
                .uri("/getProductS1/{id}", id)
                .retrieve()
                .bodyToMono(Product.class)
                .block(); // Blocking to return Product
    }

    public URI setProd(Product m) {
        return webClient.post()
                .uri("/setProdS1")
                .bodyValue(m)
                .retrieve()
                .bodyToMono(URI.class)
                .block(); // Blocking to return URI
    }

    public void deleteProd(int id) {
        webClient.delete()
                .uri("/deleteProdS1/{id}", id)
                .retrieve()
                .toBodilessEntity()
                .block(); // Blocking to execute delete
    }

    public void update(int id, Product m) {
        webClient.put()
                .uri("/updateProdS1/{id}", id)
                .bodyValue(m)
                .retrieve()
                .toBodilessEntity()
                .block(); // Blocking to execute update
    }
}
