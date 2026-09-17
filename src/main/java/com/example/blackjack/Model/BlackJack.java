package com.example.blackjack.Model;

import java.util.ArrayList;

public class BlackJack {
    /*Los jugadores no se reemplazan porque requieren un recorrido iterativo
    * sin sacar de la estructura (una consulta) y una pila solo permite
    * consultar el elemento que esta al tope. Para manejar las acciones de
    * cada jugador se necesitaria manejar mas de una pila para extraer de
    * la primera, consultar el siguiente, guardar en otra y luego reordenar
    * de nuevo en la primera pila para mantener el orden original de los
    * jugadores.
    * */
    private ArrayList<Jugador> jugadores;
    private Jugador casa;
    private Mazo mazo;
    private int turnoActualIndex;
    private boolean rondaActiva;

    //Pila para el undo
    private Pila<Movimiento> historial;

    public BlackJack() {
        mazo = new Mazo();
        jugadores = new ArrayList<>();
        casa = new Jugador("Casa");
        turnoActualIndex = 0;
        historial = new Pila<>(30);
        rondaActiva = true;
    }

    public void repartir(){

        vaciarHistorial();
        for(Jugador jugador : jugadores){
            jugador.reiniciarMano();
        }
        casa.reiniciarMano();
        for(int i = 0; i < 2; i++){
            casa.agregarCarta(mazo.obtenerUnaCartaPila());
            for(Jugador jugador : jugadores){
                jugador.agregarCarta(mazo.obtenerUnaCartaPila());
            }
        }

        turnoActualIndex = 0;
        rondaActiva = true;
    }

    public CartaInglesa pedirCarta(){
        if(!rondaActiva || turnoDelaCasa()){
            return null;
        }
        Jugador jugadorActual = getJugadorActual();
        if(jugadorActual != null && jugadorActual.isJugando()){
            CartaInglesa carta = mazo.obtenerUnaCartaPila();
            if(carta != null) {
                jugadorActual.agregarCarta(carta);
                historial.push(new Movimiento(jugadorActual, carta, "PEDIR_CARTA"));
                if (jugadorActual.getPuntaje() >= 21) {
                    plantarse();
                }
            }
            return carta;
        }
        return null;
    }

    public void plantarse(){
        Jugador jugadorActual = getJugadorActual();
        if(jugadorActual != null && rondaActiva){
            historial.push(new Movimiento(jugadorActual, null, "PLANTARSE"));
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
            casa.agregarCarta(mazo.obtenerUnaCartaPila());
        }
        casa.setJugando(false);
        finalizarRonda();
    }

    public void finalizarRonda(){
        rondaActiva = false;
        vaciarHistorial();
    }

    private void vaciarHistorial(){
        while (historial.size() > 0){
            historial.pop();
        }
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
        vaciarHistorial();
    }

    public void reiniciarRonda(){
        for(Jugador jugador : jugadores){
            jugador.reiniciarMano();
            jugador.setJugando(true);
        }
        casa.reiniciarMano();
        casa.setJugando(true);
        repartir();
    }
    
    public boolean deshacerUltimoMovimiento(){
        if(!rondaActiva || historial.size() == 0){
            return false;
        }
        Movimiento ultimoMovimiento = historial.pop();
        Jugador jugador = ultimoMovimiento.getJugador();
        if("PEDIR_CARTA".equals(ultimoMovimiento.getTipoAccion())){
            CartaInglesa cartaDevuelta = ultimoMovimiento.getCarta();
            jugador.removerUltimaCarta();
            mazo.getCartasPila().push(cartaDevuelta);
            jugador.setJugando(true);
        } else if ("PLANTARSE".equals(ultimoMovimiento.getTipoAccion())) {
            for (int i = 0; i < jugadores.size(); i++) {
                if(jugadores.get(i).equals(jugador)){
                    turnoActualIndex = i;
                    break;
                }
            }
            jugador.setJugando(true);
        }
        return true;
    }

    public Jugador getCasa(){
        return casa;
    }
    public ArrayList<Jugador> getJugadores(){
        return jugadores;
    }
    public Mazo getMazo(){
        return mazo;
    }

    public Pila<Movimiento> getHistorial(){
        return historial;
    }
    public boolean isRondaActiva(){
        return rondaActiva;
    }
}
