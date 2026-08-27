package com.example.blackjack.View;


import com.example.blackjack.Model.Carta;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.io.InputStream;


    public class CartaView extends StackPane {
        private Carta carta;
        private Image imagen;
        private ImageView imagenCarta;

        public CartaView(Carta carta) {
            this.carta = carta;

            InputStream is = getClass().getResourceAsStream("/2_of_hearts.png");

            if (is == null) {
                throw new IllegalArgumentException("Resource not found: /2_of_hearts.png");
            }

            imagen = new Image(is);
            imagenCarta = new ImageView(imagen);
            imagenCarta.setFitHeight(120);
            imagenCarta.setFitWidth(120);
            imagenCarta.setPreserveRatio(true);

            getChildren().add(imagenCarta);
        }
    }

