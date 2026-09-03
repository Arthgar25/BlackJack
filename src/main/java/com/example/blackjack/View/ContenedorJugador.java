package com.example.blackjack.View;

import com.example.blackjack.Model.Jugador;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class ContenedorJugador extends Contenedor {
    private HBox opciones;

    private QuickButton hit;
    private QuickButton stay;

    public ContenedorJugador(Jugador jugador) {
        super(jugador);

        opciones = new HBox(10);
        opciones.setAlignment(Pos.CENTER);

        hit = new QuickButton("Hit");
        hit.setMinSize(75, 25);
        stay = new QuickButton("Stay");
        stay.setMinSize(75, 25);

        opciones.getChildren().addAll(hit, stay);

        this.getChildren().addAll(opciones);
    }
    public QuickButton getHitButton() { return hit; }
    public QuickButton getStayButton() { return stay; }
}

