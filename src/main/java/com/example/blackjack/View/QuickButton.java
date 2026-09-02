package com.example.blackjack.View;
import javafx.scene.control.Button;

public class QuickButton extends Button {
    public QuickButton(String icon) {
        super(icon);
        this.setMinSize(200,25);
        this.getStyleClass().add("font");
    }
}
