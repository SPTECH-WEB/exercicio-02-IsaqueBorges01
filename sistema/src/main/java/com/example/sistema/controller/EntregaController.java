package com.example.sistema.controller;

import com.example.sistema.observer.Notificador;
import com.example.sistema.service.EntregaService;
import com.example.sistema.strategy.EntregaEconomica;
import com.example.sistema.strategy.EntregaExpressa;
import com.example.sistema.strategy.FreteStrategy;
import com.example.sistema.strategy.TransportadoraTerceirizada;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/entrega")
public class EntregaController {
    private final EntregaService entregaService;
    private final Notificador notificador;
    private final Map<String, FreteStrategy> estrategias;

    public EntregaController(EntregaService entregaService, Notificador notificador) {
        this.entregaService = entregaService;
        this.notificador = notificador;
        this.estrategias = Map.of(
                "expressa", new EntregaExpressa(),
                "economica", new EntregaEconomica(),
                "terceirizada", new TransportadoraTerceirizada()
        );
    }

    @GetMapping("/calcular")
    public double calcularFrete(@RequestParam String modalidade, @RequestParam double peso) {
        FreteStrategy estrategia = estrategias.get(modalidade.toLowerCase());
        if (estrategia == null) {
            throw new IllegalArgumentException("Modalidade inválida!");
        }
        return entregaService.calcularFrete(estrategia, peso);
    }
}
