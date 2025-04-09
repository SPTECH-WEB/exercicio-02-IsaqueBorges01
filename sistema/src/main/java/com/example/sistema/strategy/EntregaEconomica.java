package com.example.sistema.strategy;

import org.springframework.stereotype.Component;

@Component
public class EntregaEconomica implements FreteStrategy {
    @Override
    public double calcularFrete(double peso) {
        return peso * 5.0;
    }
}

