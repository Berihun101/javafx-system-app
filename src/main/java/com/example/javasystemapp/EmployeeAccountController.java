package com.example.javasystemapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeAccountController {
    static String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    static String DB_URL = "jdbc:mysql://localhost/sims";
    static String DB_USER = "root";
    static String DB_PASS = "";
    @FXML
    private Button clr_btn;

    @FXML
    private Button crt_btn;

    @FXML
    private TextField cps_tf;

    @FXML
    private ImageView un_ic;

    @FXML
    private Label lblErrorMessage;

    @FXML
    private Label lblSuccessMessage;

    @FXML
    private Button back;

    @FXML
    private TextField pass_tf;

    @FXML
    private TextField un_tf;

    @FXML
    void addUser(ActionEvent event) throws ClassNotFoundException, SQLException {
        if (un_tf.getText().equals("") || pass_tf.getText().equals("") || cps_tf.getText().equals("")) {
            lblErrorMessage.setText("Please fill in the required field to register!");
            Shaker shaker = new Shaker(un_tf);
            shaker.shake();
            Shaker shaker1 = new Shaker(pass_tf);
            shaker1.shake();
            Shaker shaker2 = new Shaker(cps_tf);
            shaker2.shake();

        }
            else {
                String empUserName = un_tf.getText();
                String empPassword = pass_tf.getText();
                String adminName = Admin.getAdminName();
                Class.forName(DB_DRIVER);
                Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO employee (username, password, adminUserName) VALUES (?, ?, ?)");
                preparedStatement.setString(1, empUserName);
                preparedStatement.setString(2, empPassword);
                preparedStatement.setString(3, adminName);
                preparedStatement.executeUpdate();
                connection.close();
                    lblErrorMessage.setText("");
                   lblSuccessMessage.setText("You have successfully added the employee!");
        }

    }

    @FXML
    void clear(ActionEvent event) {
        un_tf.setText("");
        pass_tf.setText("");
        cps_tf.setText("");
    }

    @FXML
    void handleBckBtn(ActionEvent event) throws IOException {
    Main.sceneFactory("/com/example/javasystemapp/AdminDashboard");
    }

}
