package com.example.blackjack.Model;

import java.util.ArrayList;

public class BlackJack {
    private ArrayList<Jugador> jugadores;
    private Jugador casa;
    private Mazo mazo;

    public BlackJack() {
        mazo = new Mazo();
        jugadores = new ArrayList<>();
        casa = new Jugador();
    }

    public void repartir(){
        casa.agregarCarta(mazo.obtenerUnaCarta());
        casa.agregarCarta(mazo.obtenerUnaCarta());
        for (Jugador jugador : jugadores) {
            jugador.agregarCarta(mazo.obtenerUnaCarta());
            jugador.agregarCarta(mazo.obtenerUnaCarta());
        }
    }


}
