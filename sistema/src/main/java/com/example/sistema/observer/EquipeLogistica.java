package com.example.sistema.observer;

import org.springframework.stereotype.Component;

@Component
public class EquipeLogistica implements Observer {
    @Override
    public void notificar(String mensagem) {
        System.out.println("Equipe de logística recebeu: " + mensagem);
    }
}

