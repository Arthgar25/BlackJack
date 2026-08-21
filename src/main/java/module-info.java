module com.example.blackjack {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.blackjack to javafx.fxml;
    exports com.example.blackjack;
    exports com.example.blackjack.Controller;
    opens com.example.blackjack.Controller to javafx.fxml;
}