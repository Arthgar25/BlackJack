package com.example.blackjack.Model;
/**
 * Write a description of class Mazo here.
 *
 * @author (Cecilia Curlango Rosas)
 * @version (2025-2)
 */
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Mazo {
    private Pila<CartaInglesa> cartasPila;
    public Mazo() {
        cartasPila = new Pila<>(52);
        llenar(); // crea todas las cartas, excluyendo Jokers
        mezclar();
    }

    /**
     * Obtiene todas las cartas del mazo.
     * @return
     */

    public Pila<CartaInglesa> getCartasPila() {
        return cartasPila;
    }

    public CartaInglesa obtenerUnaCartaPila() {
        if (cartasPila.size() > 0) {
            return cartasPila.pop();
        }
        return null;
    }

    public void mezclar() {
        ArrayList<CartaInglesa> lista = new ArrayList<>();
        while(cartasPila.size() > 0) {
            lista.add(cartasPila.pop());
        }
        Collections.shuffle(lista);
        for(CartaInglesa carta : lista) {
            cartasPila.push(carta);
        }
    }

    public void llenar() {
        while(cartasPila.size() > 0) {
            cartasPila.pop();
        }

        for (int i = 2; i <=14 ; i++) {
            for (Palo palo : Palo.values()) {
                CartaInglesa c = new CartaInglesa(i,palo, palo.getColor());
                cartasPila.push(c);
            }
        }
    }

    public void ordenar() {
        ArrayList<CartaInglesa> lista = new ArrayList<>();
        while(cartasPila.size() > 0) {
            lista.add(cartasPila.pop());
        }
        Collections.sort(lista);
        for(CartaInglesa carta : lista) {
            cartasPila.push(carta);
        }
    }


    @Override
    public String toString() {
        ArrayList<CartaInglesa> lista = new ArrayList<>();
        Pila<CartaInglesa> aux = new Pila<>(cartasPila.size() > 0 ? cartasPila.size() : 10);
        while(cartasPila.size() > 0) {
            aux.push(cartasPila.pop());
        }
        while(aux.size() > 0) {
            CartaInglesa carta = aux.pop();
            lista.add(carta);
            cartasPila.push(carta);
        }
        return lista.toString();
    }
}
