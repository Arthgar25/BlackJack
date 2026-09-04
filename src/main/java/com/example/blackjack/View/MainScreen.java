package com.example.blackjack.View;

import com.example.blackjack.Model.Carta;
import com.example.blackjack.Model.Jugador;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class MainScreen extends BorderPane {
    private TituloPrincipal tituloPrincipal;
    private Font turnoActual;
    private VBox cabecera;
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
    private HBox hboxJugadores;
    private Contenedor casa;
    private ArrayList<ContenedorJugador> arrayListContenedores = new ArrayList<>();


    // Configuracion


    public MainScreen() {
        tituloPrincipal = new TituloPrincipal("BlackJack");
        turnoActual = new Font("");
        turnoActual.getStyleClass().add("font-white");

        cabecera = new VBox(10, tituloPrincipal, turnoActual);
        cabecera.setAlignment(Pos.CENTER);

        setTop(cabecera);
        inicializarComponentes();
        menuPrincipal();

        getStyleClass().add("root");
    }

    public void actualizarTurno(String texto){
        turnoActual.setText(texto);
    }

    private void inicializarComponentes() {
        botonesDelMenu = new VBox(10);
        botonesDelMenu.setAlignment(Pos.CENTER);
        botonIniciarJuego = new QuickButton("Iniciar Juego");
        botonReglas = new QuickButton("Reglas");
        botonConfiguracion = new QuickButton("Configuración");
        botonSalir = new QuickButton("Salir");
        cuantosJugadores = new Font("Elige los jugadores");
        cuantosJugadores.getStyleClass().add("font-white");

        jugadores2 = new QuickButton("2 Jugadores");
        jugadores3 = new QuickButton("3 Jugadores");
        jugadores4 = new QuickButton("4 Jugadores");

        hboxJugadores = new HBox(20);
        hboxJugadores.setAlignment(Pos.CENTER);

        casa = new Contenedor(new Jugador("Casa"));
    }

    public void menuPrincipal() {
        botonesDelMenu.getChildren().clear();
        botonesDelMenu.getChildren().addAll(botonIniciarJuego,botonReglas,botonConfiguracion,botonSalir);
        setCenter(botonesDelMenu);
    }

    public void elegirJugadores() {
        botonesDelMenu.getChildren().clear();
        botonesDelMenu.getChildren().addAll(cuantosJugadores, jugadores2, jugadores3, jugadores4);
        System.out.println("test");
    }

    public void mostrarTablero(ArrayList<Jugador> jugadores, Jugador casaModel) {
        this.setCenter(null);

        casa = new Contenedor(casaModel);
        for(Carta carta : casaModel.getMano()){
            casa.agregarCartas(new CartaView(carta));
        }
        setCenter(casa);

        hboxJugadores.getChildren().clear();
        arrayListContenedores.clear();

        for(Jugador jugador : jugadores) {
            ContenedorJugador contenedorJugador = new ContenedorJugador(jugador);
            for(Carta carta : jugador.getMano()){
                contenedorJugador.agregarCartas(new CartaView(carta));
            }
            contenedorJugador.actualizarPuntaje(jugador.getPuntaje());
            arrayListContenedores.add(contenedorJugador);
            hboxJugadores.getChildren().add(contenedorJugador);
        }
        this.setBottom(hboxJugadores);
    }

    public ArrayList<ContenedorJugador> getArrayListContenedores() {
        return arrayListContenedores;
    }
    public QuickButton getBotonIniciarJuego() {return botonIniciarJuego;}
    public QuickButton getBotonReglas() {return botonReglas;}
    public QuickButton getBotonConfiguracion() {return botonConfiguracion;}
    public QuickButton getBotonSalir() {return botonSalir;}
    public QuickButton getJugadores2() {return jugadores2;}
    public QuickButton getJugadores3() {return jugadores3;}
    public QuickButton getJugadores4() {return jugadores4;}
    public Contenedor getCasa() {return casa;}
}
