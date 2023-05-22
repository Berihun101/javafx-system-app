package com.example.javasystemapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;

import java.io.IOException;

public class CustomerDashboardController {

    @FXML
    private Hyperlink logoutbtn;

    @FXML
    private static String customerName;

    @FXML
    void logout(ActionEvent event) throws IOException {
   Main.sceneFactory("/com/example/javasystemapp/customerLoginPage");

    }

    public static void setCustomerName(String customer) {
    customerName= customer;

    }
}
