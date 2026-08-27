package com.example.blackjack.View;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Toggle;
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

    // Tablero de juego


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
        botonIniciarJuego = new QuickButton("Iniciar Juego") {
            @Override
            protected void addAction() {

            }
        };
        botonReglas = new QuickButton("Reglas") {
            @Override
            protected void addAction() {

            }
        };
        botonConfiguracion = new QuickButton("Configuracion") {
            @Override
            protected void addAction() {

            }
        };
        botonSalir = new QuickButton("Salir") {
            @Override
            protected void addAction() {

            }
        };
        botonesDelMenu.setAlignment(Pos.CENTER);
        botonesDelMenu.setSpacing(10);
        botonesDelMenu.getChildren().addAll(botonIniciarJuego,botonReglas,botonConfiguracion,botonSalir);
        setAlignment(tituloPrincipal, Pos.CENTER);
        setTop(tituloPrincipal);
        setCenter(botonesDelMenu);
    }
}
