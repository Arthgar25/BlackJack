package com.example.blackjack.View;

import com.example.blackjack.Model.Jugador;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
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
    private Font cuantosJugadores;
    private QuickButton jugadores2;
    private QuickButton jugadores3;
    private QuickButton jugadores4;

    //Tablero
    private HBox contenedorJugadores;
    private ContenedorJugador casa;


    // Configuracion


    public MainScreen() {
        tituloPrincipal = new TituloPrincipal("BlackJack");
        setAlignment(tituloPrincipal, Pos.CENTER);
        setTop(tituloPrincipal);
        inicializarComponentes();
        menuPrincipal();

        getStyleClass().add("root");
    }

    private void inicializarComponentes() {
        botonesDelMenu = new VBox();
        botonesDelMenu.setAlignment(Pos.CENTER);
        botonIniciarJuego = new QuickButton("Iniciar Juego");
        botonReglas = new QuickButton("Reglas");
        botonConfiguracion = new QuickButton("Configuración");
        botonSalir = new QuickButton("Salir");

        jugadores2 = new QuickButton("2 Jugadores");
        jugadores3 = new QuickButton("3 Jugadores");
        jugadores4 = new QuickButton("4 Jugadores");

        contenedorJugadores = new HBox(20);
        contenedorJugadores.setAlignment(Pos.CENTER);

        casa = new ContenedorJugador(new Jugador());
    }

    public void menuPrincipal() {

        botonIniciarJuego = new QuickButton("Iniciar Juego");
        botonReglas = new QuickButton("Reglas");
        botonConfiguracion = new QuickButton("Configuracion");
        botonSalir = new QuickButton("Salir");
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

        cuantosJugadores = new Font("Elige los Jugadores");
        cuantosJugadores.getStyleClass().add("font");

        jugadores2 = new QuickButton("2 Jugadores");
        jugadores3 = new QuickButton("3 Jugadores");
        jugadores4 = new QuickButton("4 Jugadores");

        botonesDelMenu.setAlignment(Pos.CENTER);
        botonesDelMenu.setSpacing(10);
        botonesDelMenu.getChildren().addAll(cuantosJugadores, jugadores2, jugadores3, jugadores4);
    }

    public void mostrarTablero(int cantidadDeJugadores){
        this.setCenter(null);
        setCenter(casa);
        for(int i = 1; i <= cantidadDeJugadores; i++){
            ContenedorJugador contenedorJugador = new ContenedorJugador(new Jugador());
            contenedorJugadores.getChildren().add(contenedorJugador);
        }
        setBottom(contenedorJugadores);
    }

    public QuickButton getBotonIniciarJuego() {return botonIniciarJuego;}
    public QuickButton getBotonReglas() {return botonReglas;}
    public QuickButton getBotonConfiguracion() {return botonConfiguracion;}
    public QuickButton getBotonSalir() {return botonSalir;}
    public QuickButton getJugadores2() {return jugadores2;}
    public QuickButton getJugadores3() {return jugadores3;}
    public QuickButton getJugadores4() {return jugadores4;}
}
