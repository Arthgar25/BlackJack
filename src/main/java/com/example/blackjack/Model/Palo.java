package com.example.blackjack.Model;
/**
 * Palos de cartas de una baraja inglesa.
 *
 * @author (Cecilia Curlango Rosas)
 * @version (2025-1)
 */
public enum Palo {
    CLUBS(1,"♣\uFE0E","negro"),
    DIAMONDS(2,"♦\uFE0F","rojo"),
    HEARTS(3,"❤\uFE0F","rojo"),
    SPADES(4,"♠\uFE0F","negro");

    private final int peso;
    private final String figura;
    private final String color;

    Palo(int peso, String figura, String color) {
        this.peso = peso;
        this.figura = figura;
        this.color = color;
    }
    public int getPeso() {
        return peso;
    }
    public String getFigura() {
        return figura;
    }
    public String getColor() {
        return color;
    }
}
