module com.example.javasystemapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.javasystemapp to javafx.fxml;
    exports com.example.javasystemapp;
}