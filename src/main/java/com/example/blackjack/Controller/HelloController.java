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

        view.getJugarDeNuevo().setOnAction(event -> reiniciarRonda());
        view.getBotonMenuPrincipal().setOnAction(event -> view.menuPrincipal());
    }

    private void reiniciarRonda() {
        model.getMazo().getCartas().clear();
        model.getMazo().llenar();
        model.getMazo().mezclar();
        model.reiniciarRonda();
        view.mostrarTablero(model.getJugadores(), model.getCasa());
        actualizarIndicadorTurno();
        configurarAccionesJugadores();
        iniciarJuego(model.getJugadores().size());
    }

    private void iniciarJuego(int numJugadores){
        model.inicializarJugadores(numJugadores);
        model.repartir();
        view.mostrarTablero(model.getJugadores(), model.getCasa());

        actualizarIndicadorTurno();

        configurarAccionesJugadores();
    }

    private void actualizarIndicadorTurno(){
        if(model.turnoDelaCasa()){
            view.getCasa().actualizarManoYCartas(model.getCasa());
            view.actualizarTurno("Turno de: La Casa - Juego Terminado!");
            deshabilitarTodosLosBotones();
            evaluarYMostrarResultados();
            view.mostrarBotonesFinJuego();
        } else{
            view.getCasa().actualizarPuntaje(model.getCasa().getPuntaje());
            Jugador actual = model.getJugadorActual();
            if (actual != null) {
                view.actualizarTurno("Turno de: " + actual.getNombre());
                gestionarBotonesPorturno(actual);
            }
        }
    }

    private void evaluarYMostrarResultados(){
        ArrayList<ContenedorJugador> contenedores = view.getArrayListContenedores();
        for (int i = 0; i < contenedores.size(); i++) {
            Jugador jugador = model.getJugadores().get(i);
            ContenedorJugador contenedor = contenedores.get(i);

            String resultado = model.evaluarResultado(jugador);

            contenedor.mostrarResultadoFinal(jugador.getPuntaje(), resultado);
        }
    }

    private void gestionarBotonesPorturno(Jugador jugadorActual){
        ArrayList<ContenedorJugador> contenedores = view.getArrayListContenedores();
        for (int i = 0; i < contenedores.size(); i++) {
            Jugador jugadorModel = model.getJugadores().get(i);
            ContenedorJugador contenedorView = contenedores.get(i);
            boolean esSuTurno = (jugadorModel == jugadorActual);
            contenedorView.getHitButton().setDisable(!esSuTurno);
            contenedorView.getStayButton().setDisable(!esSuTurno);
        }
    }

    private void deshabilitarTodosLosBotones(){
        for(ContenedorJugador contenedor : view.getArrayListContenedores()){
            contenedor.getHitButton().setDisable(true);
            contenedor.getStayButton().setDisable(true);
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
