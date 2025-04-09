package com.example.sistema.strategy;

import org.springframework.stereotype.Component;

@Component
public class TransportadoraTerceirizada implements FreteStrategy {
    @Override
    public double calcularFrete(double peso) {
        return peso * 7.0;
    }
}
