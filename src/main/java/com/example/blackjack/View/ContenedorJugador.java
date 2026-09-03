package com.example.blackjack.View;

import com.example.blackjack.Model.Jugador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ContenedorJugador extends VBox {
    private Font nombreJugador;
    private Label puntajeJugador;
    private HBox cartas;
    private HBox opciones;

    private QuickButton hit;
    private QuickButton stay;

    public ContenedorJugador(Jugador jugador) {
        this.setSpacing(50);
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(10,20,50,20));

        nombreJugador = new Font(jugador.getNombre());
        puntajeJugador = new Label("Puntos: 0");

        cartas = new HBox(5);
        cartas.setAlignment(Pos.CENTER);

        opciones = new HBox(10);
        opciones.setAlignment(Pos.CENTER);

        hit = new QuickButton("Hit");
        hit.setMinSize(75, 25);
        stay = new QuickButton("Stay");
        stay.setMinSize(75, 25);

        opciones.getChildren().addAll(hit, stay);

        this.getChildren().addAll(nombreJugador, cartas, opciones);
    }


    public void agregarCartas(CartaView carta) {
        cartas.getChildren().add(carta);
    }
    public void actualizarPuntaje(int puntaje){
        puntajeJugador.setText("Puntos: " + puntaje);
    }
    public QuickButton getHitButton() { return hit; }
    public QuickButton getStayButton() { return stay; }
}

