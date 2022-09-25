package com.example.demooauth2;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import static org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction.clientRegistrationId;


@RestController
@RequestMapping
@RequiredArgsConstructor
public class DemoController {
    private final WebClient webClient;

    @GetMapping("/demo")
    public String demo() {
        return this.webClient
            .get()
            .uri("http://localhost:8080/v1/products")
            .attributes(clientRegistrationId("keycloak"))
            .retrieve()
            .bodyToMono(String.class)
            .log()
            .block();
    }
}
