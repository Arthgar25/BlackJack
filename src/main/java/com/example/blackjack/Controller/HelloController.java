package com.example.blackjack.Controller;

import com.example.blackjack.Model.BlackJack;
import com.example.blackjack.Model.CartaInglesa;
import com.example.blackjack.Model.Jugador;
import com.example.blackjack.View.CartaView;
import com.example.blackjack.View.Contenedor;
import com.example.blackjack.View.ContenedorJugador;
import com.example.blackjack.View.MainScreen;
import javafx.application.Platform;

import java.util.ArrayList;

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

        actualizarIndicadorTurno();

        configurarAccionesJugadores();
    }

    private void actualizarIndicadorTurno(){
        view.getCasa().actualizarPuntaje(model.getCasa().getPuntaje());
        if(model.turnoDelaCasa()){
            view.actualizarTurno("Turno de: La Casa");
        } else{
            Jugador actual = model.getJugadorActual();
            if (actual != null) {
                view.actualizarTurno("Turno de: " + actual.getNombre());
            }
        }
    }

    private void configurarAccionesJugadores(){
        ArrayList<ContenedorJugador> contenedores = view.getArrayListContenedores();
        for (int i = 0; i < contenedores.size(); i++) {
            ContenedorJugador contenedor = contenedores.get(i);
            Jugador jugadorModel = model.getJugadores().get(i);
            contenedor.getHitButton().setOnAction(event -> {
                if (model.getJugadorActual() == jugadorModel) {
                    CartaInglesa cartaObtenida = model.pedirCarta();
                    if(cartaObtenida != null){
                        contenedor.agregarCartas(new CartaView(cartaObtenida));
                        contenedor.actualizarPuntaje(jugadorModel.getPuntaje());
                    }
                    actualizarIndicadorTurno();
                }
            });
            contenedor.getStayButton().setOnAction(event -> {
                if(model.getJugadorActual() == jugadorModel){
                    model.plantarse();
                    actualizarIndicadorTurno();
                }
            });
        }
    }
}
