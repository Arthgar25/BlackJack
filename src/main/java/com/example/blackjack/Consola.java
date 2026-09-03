package com.example.blackjack;

import com.example.blackjack.Controller.HelloController;
import com.example.blackjack.Model.Jugador;
import com.example.blackjack.Model.Mazo;

public class Consola {
    public static void main(String[] args) {
        Jugador jugador = new Jugador("");
        Jugador casa = new Jugador("Casa");
        Mazo mazo = new Mazo();

        while(true){

            iniciarJuego(jugador, casa, mazo);
            System.out.println(jugador.getMano());
            System.out.println(casa.getMano());
            break;
        }
    }

    public static void iniciarJuego(Jugador jugador, Jugador casa, Mazo mazo) {
        jugador.agregarCarta(mazo.obtenerUnaCarta());
        jugador.agregarCarta(mazo.obtenerUnaCarta());
        casa.agregarCarta(mazo.obtenerUnaCarta());
        casa.agregarCarta(mazo.obtenerUnaCarta());
    }
}
