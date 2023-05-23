package com.example.javasystemapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;

import java.io.IOException;

public class EmployeeDashboardController {

    @FXML
    private Hyperlink logoutbtn;

    @FXML
    void logout(ActionEvent event) throws IOException {
   Main.sceneFactory("/com/example/javasystemapp/employeeLoginPage");
    }

}
