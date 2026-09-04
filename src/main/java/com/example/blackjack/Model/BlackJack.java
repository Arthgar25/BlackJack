package com.example.blackjack.Model;

import java.util.ArrayList;

public class BlackJack {
    private ArrayList<Jugador> jugadores;
    private Jugador casa;
    private Mazo mazo;
    private int turnoActualIndex;

    public BlackJack() {
        mazo = new Mazo();
        jugadores = new ArrayList<>();
        casa = new Jugador("Casa");
        turnoActualIndex = 0;
    }

    public void repartir(){
        for(Jugador jugador : jugadores){
            jugador.reiniciarMano();
        }
        casa.reiniciarMano();
        for(int i = 0; i < 2; i++){
            casa.agregarCarta(mazo.obtenerUnaCarta());
            for(Jugador jugador : jugadores){
                jugador.agregarCarta(mazo.obtenerUnaCarta());
            }
        }

        turnoActualIndex = 0;
    }

    public CartaInglesa pedirCarta(){
        Jugador jugadorActual = getJugadorActual();
        if(jugadorActual != null && jugadorActual.isJugando()){
            CartaInglesa carta = mazo.obtenerUnaCarta();
            jugadorActual.agregarCarta(carta);
            if(jugadorActual.getPuntaje() >= 21){
                plantarse();
            }
            return carta;
        }
        return null;
    }

    public void plantarse(){
        Jugador jugadorActual = getJugadorActual();
        if(jugadorActual != null){
            jugadorActual.setJugando(false);
            avanzarTurno();
        }
    }

    private void avanzarTurno(){
        turnoActualIndex++;
        if(turnoActualIndex >= jugadores.size()){
            jugarCasa();
        }
    }

    public void jugarCasa(){
        while(casa.getPuntaje() < 17){
            casa.agregarCarta(mazo.obtenerUnaCarta());
        }
        casa.setJugando(false);
    }

    public String evaluarResultado(Jugador jugador){
        int puntosJugador = jugador.getPuntaje();
        int puntosCasa = casa.getPuntaje();
        if(puntosJugador > 21){
            return "Perdiste (Te pasaste)";
        } else if(puntosCasa > 21){
            return "Ganaste (La casa se paso)";
        } else if(puntosJugador > puntosCasa){
            return "Ganaste";
        } else if(puntosJugador < puntosCasa){
            return "Perdiste";
        } else {
            return "Empate";
        }
    }

    public Jugador getJugadorActual(){
        if(turnoActualIndex < jugadores.size()){
            return jugadores.get(turnoActualIndex);
        }
        return null;
    }

    public boolean turnoDelaCasa(){
        return turnoActualIndex >= jugadores.size();
    }
    public void inicializarJugadores(int numJugadores){
        jugadores.clear();
        for(int i = 1; i <= numJugadores; i++){
            jugadores.add(new Jugador("Jugador " + i));
        }
        casa.reiniciarMano();
        turnoActualIndex = 0;
    }

    public Jugador getCasa(){
        return casa;
    }
    public ArrayList<Jugador> getJugadores(){
        return jugadores;
    }
}
