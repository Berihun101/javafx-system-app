package com.example.javasystemapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;

import java.io.IOException;

public class AdminDashboardController {
    static String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    static String DB_URL = "jdbc:mysql://localhost/sims";
    static String DB_USER = "root";
    static String DB_PASS = "";
    @FXML
    private Label adminName;

    @FXML
    private Label emp3;

    @FXML
    private Label emp2;

    @FXML
    private Label emp1;
    @FXML
    private Button updatebtn;

    @FXML
    private Hyperlink logoutbtn;

    @FXML
    private Button addbtn;

    @FXML
    private Button deletebtn;

    @FXML
    void logout(ActionEvent event) throws IOException {
     Main.sceneFactory("/com/example/javasystemapp/AdminLoginPage");
    }

    @FXML
    void Addemployee(ActionEvent event) throws IOException {
     Main.sceneFactory("/com/example/javasystemapp/AddEmployee");

    }

    @FXML
    void DeleteEmployee(ActionEvent event) {

    }

    @FXML
    void ubdateemployee(ActionEvent event) {

    }
}
