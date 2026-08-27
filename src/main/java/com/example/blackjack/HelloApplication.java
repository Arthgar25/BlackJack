package com.example.blackjack;

import com.example.blackjack.Model.Carta;
import com.example.blackjack.Model.CartaInglesa;
import com.example.blackjack.Model.Palo;
import com.example.blackjack.View.CartaView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        BorderPane root = new BorderPane();


        String css = getClass().getResource("style.css").toExternalForm();
        Scene scene = new Scene(root, 720, 480);
        scene.getStylesheets().add(css);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}
