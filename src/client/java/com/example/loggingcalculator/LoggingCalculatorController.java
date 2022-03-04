package com.example.loggingcalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class LoggingCalculatorController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void numberClicked(ActionEvent e) {
        System.out.println(((Button) e.getSource()).getText());
    }

    public void operatorClicked(ActionEvent e) {
        System.out.println(((Button) e.getSource()).getText());
    }
}