package com.example.blackjack.View;

import com.example.blackjack.Model.Jugador;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ContenedorJugador extends VBox {
    private Font nombreJugador;
    private HBox cartas;
    private HBox opciones;

    private QuickButton hit;
    private QuickButton stay;

    public ContenedorJugador(Jugador jugador) {
        cartas = new HBox();
        opciones = new HBox();
        hit = new QuickButton("Hit");
        hit.setMinSize(75, 25);
        stay = new QuickButton("Stay");
        stay.setMinSize(75, 25);
        nombreJugador = new Font(jugador.getNombre());

        opciones.getChildren().addAll(hit, stay);
        this.getChildren().addAll(nombreJugador, cartas, opciones);
    }

    public void agregarCartas(CartaView carta) {
        cartas.getChildren().add(carta);
    }
}
