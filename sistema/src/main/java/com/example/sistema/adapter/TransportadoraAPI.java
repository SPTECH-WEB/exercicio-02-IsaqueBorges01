package com.example.sistema.adapter;

import org.springframework.stereotype.Service;

@Service
public class TransportadoraAPI {
    public double calcularFreteExterno(double peso) {
        return peso * 8.0;
    }
}

