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
                .header("authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0b2tlbiIsImF1ZCI6ImFjNDhjYzgzLWJlZjItNGRkNi05OTAzLThjZjljZGRlMzNhYSIsInByZHRfY2QiOiIiLCJpc3MiOiJ1bm9ndyIsImV4cCI6MTcyNDMzMjc5MSwiaWF0IjoxNzI0MjQ2MzkxLCJqdGkiOiJQU3lDMjNZWFNDem5pNkRIeFVpUW5jR1R4M2hXRUNwWldhQnMifQ.kfIKfR5qZTJ9swDNl2Iy-hNtk5mc0NIicthJx2eigXo13ouhmAk5sU1aZ9dUKvC0ISkAq-Pa3ye5TLQwMcwurQ")
                .header("appkey", "PSyC23YXSCzni6DHxUiQncGTx3hWECpZWaBs")
                .header("appsecret", "+vM1U8oCPr80oH9Gqolt8Caz7o6FroFCjt5eQRNhcVPbia/nlMuvU9OlS+6zF5K7f51dXq1/eR80l9JAa1q7N1bvxdRVW8W/mGEsxP7F0xbtIIvbOL+YiJbnE/suVxvteXjclmnkZEl1bWidyxdkEDWZMwSI6rULLikxzJ/kJ8rY+PlFe20=")
                .header("tr_id", "FHKST01010100")
                .retrieve()
                .bodyToMono(Object.class);
    }
}
