package com.example.blackjack.Model;
import com.example.blackjack.View.MainScreen;

import java.util.ArrayList;

public class Jugador {
    private ArrayList<Carta> mano = new ArrayList<Carta>();
    private int puntaje;
    private boolean jugando = false;

    public Jugador(){
        jugando = true;
        puntaje = 0;
    }

    public void agregarCarta(Carta carta){
        mano.add(carta);
    }

    public ArrayList<Carta> getMano() {
        return mano;
    }

    public void setMano(ArrayList<Carta> mano) {
        this.mano = mano;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje+=puntaje;
    }

    public boolean isJugando() {
        return jugando;
    }
    public void setJugando(boolean jugando) {
        this.jugando = jugando;
    }
}
