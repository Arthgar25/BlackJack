package com.example.blackjack.View;

import javafx.scene.control.Label;

public class Font extends Label {
    public Font(String texto) {
        super(texto);
        this.getStyleClass().add("font");
    }
}
