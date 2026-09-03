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

        view.getJugadores2().setOnAction(event -> iniciarJuego(2));
        view.getJugadores3().setOnAction(event -> iniciarJuego(3));
        view.getJugadores4().setOnAction(event -> iniciarJuego(4));
    }

    private void iniciarJuego(int numJugadores){
        model.inicializarJugadores(numJugadores);
        model.repartir();
        view.mostrarTablero(model.getJugadores(), model.getCasa());
    }
}
