package com.example.javasystemapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MainPageController {

    @FXML
    private Button admin_btn;

    @FXML
    private ImageView admin_ic;

    @FXML
    private Button cus_btn;

    @FXML
    private ImageView cus_ic;

    @FXML
    private Button emp_btn;

    @FXML
    private AnchorPane emp_ic;

    @FXML
    public void handleAdminBtn(ActionEvent event) throws IOException {
        Main.sceneFactory("/com/example/javasystemapp/AdminLoginPage");
    }

    @FXML
    public void handleCusBtn(ActionEvent event) throws IOException {
        Main.sceneFactory("/com/example/javasystemapp/CustomerLoginPage");
    }
    public void handleEmpBtn(ActionEvent event) throws IOException {
        Main.sceneFactory("/com/example/javasystemapp/EmployeeLoginPage");
    }
}
