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
        String path = obtenerRutaImagen(carta);
        InputStream is = getClass().getResourceAsStream(path);

        if (is == null) {
            System.err.println("Imagen no encontrada: " + path);
            is = getClass().getResourceAsStream("/2_of_hearts.png");
        }

        if(is != null) {
            imagen = new Image(is);
            imagenCarta = new ImageView(imagen);
            imagenCarta.setFitHeight(120);
            imagenCarta.setFitWidth(120);
            imagenCarta.setPreserveRatio(true);
            getChildren().add(imagenCarta);
        }

    }
    private String obtenerRutaImagen(Carta carta) {
        String valor;
        String palo;
        boolean face = false;
        switch(carta.getValor()){
            case 14:
                valor = "ace";
                break;
            case 11:
                valor = "jack";
                face = true;
                break;
            case 12:
                valor = "queen";
                face = true;
                break;
            case 13:
                valor = "king";
                face = true;
                break;
            default:
                valor = String.valueOf(carta.getValor());
                break;
        }
        if(face){
            palo = carta.getPalo().name().toLowerCase() + "2";
        }else{
            palo = carta.getPalo().name().toLowerCase();
        }

        return "/" + valor + "_of_" + palo + ".png";
    }
}