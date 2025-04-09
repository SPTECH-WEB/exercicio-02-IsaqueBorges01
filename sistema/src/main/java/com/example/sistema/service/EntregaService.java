package com.example.sistema.service;

import com.example.sistema.observer.Notificador;
import com.example.sistema.strategy.FreteStrategy;
import org.springframework.stereotype.Service;

@Service
public class EntregaService {
    private final Notificador notificador;

    public EntregaService(Notificador notificador) {
        this.notificador = notificador;
    }

    public double calcularFrete(FreteStrategy estrategia, double peso) {
        double custo = estrategia.calcularFrete(peso);
        notificador.notificarTodos("Entrega concluída com custo de R$ " + custo);
        return custo;
    }
}

