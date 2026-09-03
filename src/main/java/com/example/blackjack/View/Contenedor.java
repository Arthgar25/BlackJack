package com.example.blackjack.View;

import com.example.blackjack.Model.Jugador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Contenedor extends VBox {
    private Font nombreJugador;
    private Label puntajeJugador;
    private HBox cartas;


    public Contenedor(Jugador jugador) {
        this.setSpacing(50);
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(10,20,50,20));

        nombreJugador = new Font(jugador.getNombre());
        puntajeJugador = new Label("Puntos: 0");

        cartas = new HBox(5);
        cartas.setAlignment(Pos.CENTER);

        this.getChildren().addAll(nombreJugador, cartas);
    }


    public void agregarCartas(CartaView carta) {
        cartas.getChildren().add(carta);
    }
    public void actualizarPuntaje(int puntaje){
        puntajeJugador.setText("Puntos: " + puntaje);
    }
}
