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

    @PostMapping("/calcular")
    public String realizarEntrega(@RequestBody Map<String, Object> dados) {
        String modalidade = dados.get("modalidade").toString().toLowerCase();
        double peso = Double.parseDouble(dados.get("peso").toString());

        FreteStrategy estrategia = estrategias.get(modalidade);

        if (estrategia == null) {
            throw new IllegalArgumentException("Modalidade inválida. As opções válidas são: expressa, economica ou terceirizada.");
        }

        double valor = entregaService.calcularFrete(estrategia, peso);

        notificador.notificarTodos("Entrega concluída com sucesso. Modalidade: " + modalidade + " | Valor do frete: R$ " + valor);

        return "Entrega realizada com sucesso! Frete: R$ " + valor;
    }
}
