package com.example.sistema.observer;

import org.springframework.stereotype.Component;

@Component
public class Cliente implements Observer {
    @Override
    public void notificar(String mensagem) {
        System.out.println("Cliente recebeu: " + mensagem);
    }
}

