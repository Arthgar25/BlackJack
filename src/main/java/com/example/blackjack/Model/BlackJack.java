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

    public void inicializarJugadores(int numJugadores){
        for(int i = 0; i < numJugadores; i++){
            jugadores.add(new Jugador());
        }
    }

}
