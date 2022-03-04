package com.example.loggingcalculator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class LoggingCalculatorController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}