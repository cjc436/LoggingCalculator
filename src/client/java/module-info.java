module com.example.loggingcalculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.loggingcalculator to javafx.fxml;
    exports com.example.loggingcalculator;
}