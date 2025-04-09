package com.example.sistema.observer;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Notificador {
    private final List<Observer> observers = new ArrayList<>();

    public void adicionarObserver(Observer observer) {
        observers.add(observer);
    }

    public void removerObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notificarTodos(String mensagem) {
        for (Observer observer : observers) {
            observer.notificar(mensagem);
        }
    }
}

