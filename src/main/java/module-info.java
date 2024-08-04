module com.example.economicanalysisapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.sql;

    opens com.example.economicanalysisapp to javafx.fxml;
    exports com.example.economicanalysisapp;
}