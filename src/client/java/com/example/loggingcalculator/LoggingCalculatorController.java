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

    public void numberClicked(ActionEvent e) {
        String c = ((Button) e.getSource()).getText();
        calculator.addIntegerInput(c);
        outputScreen.setText(calculator.getDisplayNumber());
    }

    public void operatorClicked(ActionEvent e) {
        String c = ((Button) e.getSource()).getText();
        calculator.addOperatorInput(c);
        outputScreen.setText(calculator.getDisplayNumber());
    }

    public void clearClicked(ActionEvent e) {
        calculator.reset();
        outputScreen.setText("");
    }

    public void evaluatorClicked(ActionEvent e) {
        String result = calculator.finalEvaluation();
        if (result == null)
            errorDialog.setVisible(true);
        else
            outputScreen.setText(result);
    }

    public void undoClicked(ActionEvent e) {
        calculator.undo();
        errorDialog.setVisible(false);
    }

    public void resetClicked(ActionEvent e) {
        calculator.reset();
        errorDialog.setVisible(false);
        outputScreen.setText("");
    }
}