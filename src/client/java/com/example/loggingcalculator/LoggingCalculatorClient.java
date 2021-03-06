package com.example.loggingcalculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;

public class LoggingCalculatorClient extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoggingCalculatorClient.class.getResource("calculator-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 550, 580);
        stage.setTitle("Logging Calculator");
        stage.setScene(scene);
        stage.setOnCloseRequest(event -> ServerHandler.sendClose());
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}