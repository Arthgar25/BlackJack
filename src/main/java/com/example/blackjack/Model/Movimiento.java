package com.example.blackjack.Model;

public class Movimiento {
    private Jugador jugador;
    private CartaInglesa carta;
    private String tipoAccion;

    public Movimiento(Jugador jugador, CartaInglesa carta, String tipoAccion) {
        this.jugador = jugador;
        this.carta = carta;
        this.tipoAccion = tipoAccion;
    }
    public Jugador getJugador() {
        return jugador;
    }
    public CartaInglesa getCarta() {
        return carta;
    }
    public String getTipoAccion() {
        return tipoAccion;
    }
}
