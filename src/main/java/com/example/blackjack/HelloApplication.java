package com.example.blackjack;

import com.example.blackjack.Controller.HelloController;
import com.example.blackjack.Model.BlackJack;
import com.example.blackjack.View.MainScreen;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        MainScreen view = new MainScreen();
        BlackJack model = new BlackJack();
        HelloController controller = new HelloController(view, model);
        
        Scene scene = new Scene(view, 720, 480);
        String css = getClass().getResource("style.css").toExternalForm();
        scene.getStylesheets().add(css);

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}
