package com.example.loggingcalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;

public class LoggingCalculatorController {
    @FXML
    private Label outputScreen;
    @FXML
    private DialogPane errorDialog;

    private CalculatorSystem calculator = new CalculatorSystem();
    private boolean disableButtons = false;

    public void numberClicked(ActionEvent e) {
        if (disableButtons) return;
        String c = ((Button) e.getSource()).getText();
        calculator.addIntegerInput(c);
        outputScreen.setText(calculator.getDisplayNumber());
    }

    public void operatorClicked(ActionEvent e) {
        if (disableButtons) return;
        String c = ((Button) e.getSource()).getText();
        calculator.addOperatorInput(c);
        outputScreen.setText(calculator.getDisplayNumber());
    }

    public void clearClicked(ActionEvent e) {
        if (disableButtons) return;
        calculator.reset();
        outputScreen.setText("");
    }

    public void evaluatorClicked(ActionEvent e) {
        if (disableButtons) return;
        String result = calculator.finalEvaluation();
        if (result == null) {
            errorDialog.setVisible(true);
            disableButtons = true;
        } else {
            outputScreen.setText(result);
        }
    }

    public void undoClicked(ActionEvent e) {
        calculator.undo();
        errorDialog.setVisible(false);
        disableButtons = false;
    }

    public void resetClicked(ActionEvent e) {
        calculator.reset();
        errorDialog.setVisible(false);
        outputScreen.setText("");
        disableButtons = false;
    }
}