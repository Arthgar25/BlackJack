package com.example.blackjack.View;


import javafx.scene.control.Label;

public class TituloPrincipal extends Label {
    public TituloPrincipal(String texto) {
        super(texto);
        getStyleClass().add("titulo-principal");
    }
}
