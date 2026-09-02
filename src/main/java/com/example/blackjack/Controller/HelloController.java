package com.example.blackjack.Controller;

import com.example.blackjack.Model.BlackJack;
import com.example.blackjack.View.MainScreen;
import javafx.application.Platform;

public class HelloController {
    private MainScreen view;
    private BlackJack model;

    public HelloController(MainScreen view, BlackJack model) {
        this.view = view;
        this.model = model;
        configurarEventos();
    }

    private void configurarEventos() {
        view.getBotonIniciarJuego().setOnAction(event -> view.elegirJugadores());
        view.getBotonSalir().setOnAction(e -> Platform.exit());
    }
}
