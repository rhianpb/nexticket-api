package com.nexticket.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController //Recebe requisições HTTP e devolve respostas diretamente para o cliente.
@RequestMapping("/health")//define o caminho base desse controller.
public class HealthController {

    @GetMapping//quando alguém fizer uma requisição HTTP GET para /health, execute esse método.
    public Map<String, String> health () {
        return Map.of(
                "status", "UP",
                "application", "NexTicket API"
        );
    }
}
