package com.example.blackjack.View;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class MainScreen extends BorderPane {
    private TituloPrincipal tituloPrincipal;
    // Menu principal
    private VBox botonesDelMenu;
    private QuickButton botonIniciarJuego;
    private QuickButton botonReglas;
    private QuickButton botonConfiguracion;
    private QuickButton botonSalir;

    // Iniciar Juego
    // Seleccion de jugadores
    private Label cuantosJugadores;
    private QuickButton jugadores2;
    private QuickButton jugadores3;
    private QuickButton jugadores4;

    // Configuracion


    public MainScreen() {
        tituloPrincipal = new TituloPrincipal("BlackJack");
        setAlignment(tituloPrincipal, Pos.CENTER);
        setTop(tituloPrincipal);

        menuPrincipal();

        getStyleClass().add("root");
    }

    public void menuPrincipal() {
        botonesDelMenu = new VBox();
        botonIniciarJuego = new QuickButton("Iniciar Juego");
        botonReglas = new QuickButton("Reglas");
        botonConfiguracion = new QuickButton("Configuracion");
        botonSalir = new QuickButton("Salir");
        botonesDelMenu.setAlignment(Pos.CENTER);
        botonesDelMenu.setSpacing(10);
        botonesDelMenu.getChildren().addAll(botonIniciarJuego,botonReglas,botonConfiguracion,botonSalir);
        setAlignment(tituloPrincipal, Pos.CENTER);
        setTop(tituloPrincipal);
        setCenter(botonesDelMenu);
    }

    public void elegirJugadores() {
        botonesDelMenu.getChildren().clear();
        botonIniciarJuego.setVisible(false);
        botonReglas.setVisible(false);
        botonConfiguracion.setVisible(false);
        botonSalir.setVisible(false);

        jugadores2 = new QuickButton("2 Jugadores");
        jugadores3 = new QuickButton("3 Jugadores");
        jugadores4 = new QuickButton("4 Jugadores");

        botonesDelMenu.setAlignment(Pos.CENTER);
        botonesDelMenu.setSpacing(10);
        botonesDelMenu.getChildren().addAll(jugadores2, jugadores3, jugadores4);
    }

    public QuickButton getBotonIniciarJuego() {
        return botonIniciarJuego;
    }
    public QuickButton getBotonReglas() {
        return botonReglas;
    }
    public QuickButton getBotonConfiguracion() {
        return botonConfiguracion;
    }
    public QuickButton getBotonSalir() {
        return botonSalir;
    }
}
