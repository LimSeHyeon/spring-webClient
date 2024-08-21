package com.example.webclient;

import org.springframework.web.reactive.function.client.WebClient;

public class WebClientController {
    private final WebClient webClient;

    public WebClientController(WebClient webClient) {
        this.webClient = webClient;
    }

    //API 요청
    public Object getData() {
        String url = "";
        return 0;
    }
}
