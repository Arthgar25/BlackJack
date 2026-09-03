package com.example.blackjack.Model;
import com.example.blackjack.View.MainScreen;

import java.util.ArrayList;

public class Jugador {
    private String nombre;
    private ArrayList<Carta> mano = new ArrayList<Carta>();
    private int puntaje;
    private boolean jugando = false;

    public Jugador(String nombre){
        jugando = true;
        puntaje = 0;
        this.nombre = nombre;
    }

    public int getPuntaje() {
        int puntaje = 0;
        int aces = 0;
        for(Carta carta : mano){
            int valor = carta.getValor();
            if(valor >= 11 && valor <= 13){
                puntaje += 10;
            } else if(valor == 14){
                aces++;
                puntaje += 11;
            } else{
                puntaje += valor;
            }
        }
        while(puntaje > 21 && aces > 0){
            puntaje -= 10;
            aces--;
        }
        return puntaje;
    }

    public boolean esBust(){return getPuntaje() > 21;}
    public void reiniciarMano(){
        mano.clear();
        jugando = true;
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
    public void setPuntaje(int puntaje) {
        this.puntaje+=puntaje;
    }
    public boolean isJugando() {
        return jugando;
    }
    public void setJugando(boolean jugando) {
        this.jugando = jugando;
    }
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
