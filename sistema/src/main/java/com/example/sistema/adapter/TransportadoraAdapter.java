package com.example.sistema.adapter;

import org.springframework.stereotype.Component;

@Component
public class TransportadoraAdapter implements TransportadoraExterna {
    private final TransportadoraAPI api;

    public TransportadoraAdapter(TransportadoraAPI api) {
        this.api = api;
    }

    @Override
    public double calcularCustoEntrega(double peso) {
        return api.calcularFreteExterno(peso);
    }
}

