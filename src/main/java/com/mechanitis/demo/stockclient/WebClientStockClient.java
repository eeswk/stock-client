package com.mechanitis.demo.stockclient;

import java.io.IOException;
import java.time.Duration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Slf4j
public class WebClientStockClient {

    private WebClient webClient;

    public WebClientStockClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public Flux<StockPrice> priceFor(String symbol) {
        return webClient.get()
                .uri("http://localhost:8080/stocks/{symbol}", symbol)
                .retrieve()
                .bodyToFlux(StockPrice.class)
                .retryBackoff(5, Duration.ofSeconds(1), Duration.ofSeconds(20))
                .doOnError(IOException.class, e -> log.error(e.getMessage()));
        //return Flux.fromArray(new StockPrice[0]);
    }
}
