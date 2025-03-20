package com.example.webclient;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class WebClientController {
    private final WebClient webClient;

    public WebClientController(WebClient webClient) {
        this.webClient = webClient;
    }

    //API 요청
    @PostMapping("/stock")
    public Mono<Object> getData(@RequestParam String param1, @RequestParam String param2) {
        return webClient.get()
                .uri("https://openapi.koreainvestment.com:9443/uapi/domestic-stock/v1/quotations/inquire-price?FID_COND_MRKT_DIV_CODE={param1}&FID_INPUT_ISCD={param2}", param1, param2)
                .header("authorization", "")
                .header("appkey", "")
                .header("appsecret", "")
                .header("tr_id", "FHKST01010100")
                .retrieve()
                .bodyToMono(Object.class);
    }
}
