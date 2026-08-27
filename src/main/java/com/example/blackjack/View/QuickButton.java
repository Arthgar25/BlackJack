package com.example.blackjack.View;
import javafx.scene.control.Button;

public abstract class QuickButton extends Button {
    public QuickButton(String icon) {
        super(icon);
        this.setMinSize(200,25);
        this.setOnAction((e) -> addAction());
    }
    protected abstract void addAction();
}
