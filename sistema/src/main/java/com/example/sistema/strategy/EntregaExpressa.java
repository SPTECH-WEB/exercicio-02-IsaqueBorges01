package com.example.sistema.strategy;

import org.springframework.stereotype.Component;

@Component
public class EntregaExpressa implements FreteStrategy {
    @Override
    public double calcularFrete(double peso) {
        return peso * 10.0;
    }
}

