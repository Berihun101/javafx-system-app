package com.example.javasystemapp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class CustomerCreateAccountController {

    static String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    static String DB_URL = "jdbc:mysql://localhost/sims";
    static String DB_USER = "root";
    static String DB_PASS = "";

    @FXML
    public Button clr_btn;

    @FXML
    private Button back;

    @FXML
    public TextField cps_tf;

    @FXML
    public Button crt_btn;

    @FXML
    public Label lblErrorMessage;

    @FXML
    public Label lblSuccessMessage;

    @FXML
    public TextField pass_tf;

    @FXML
    private Hyperlink backlink;

    @FXML
    public ImageView un_ic;

    @FXML
    public TextField un_tf;

    @FXML
    public void addUser() throws IOException, SQLException, ClassNotFoundException {
        String key = un_tf.getText();
        if (checkPassword()) {
            if (!searchUser(key)) {
                String username = un_tf.getText();
                String password = pass_tf.getText();
                Class.forName(DB_DRIVER);
                Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
                PreparedStatement st = con.prepareStatement("insert into customer (username, password) values (?, ?)");
                st.setString(1, username);
                st.setString(2, password);
                lblErrorMessage.setText("");
                lblSuccessMessage.setText("");
                lblSuccessMessage.setStyle("-fx-text-fill: green;");
                lblSuccessMessage.setText("User Successfully added!");
                st.executeUpdate();
                st.close();
                con.close();
            } else {
                System.out.println("User Exists!");
                lblErrorMessage.setText("");
                lblSuccessMessage.setText("");
                lblErrorMessage.setStyle("-fx-text-fill: red;");
                lblErrorMessage.setText("A user with the same name already exists in the system.");
                un_tf.clear();
                pass_tf.clear();
                cps_tf.clear();
            }
        } else {
            lblErrorMessage.setText("");
            lblSuccessMessage.setText("");
            lblErrorMessage.setStyle("-fx-text-fill: red;");
            lblErrorMessage.setText("The two Passwords do not match!");
        }
    }

    @FXML
    public void clear() {
        un_tf.setText("");
        pass_tf.setText("");
        cps_tf.setText("");
    }

    public static boolean searchUser(String key) throws ClassNotFoundException, SQLException {
        boolean userExists = false;
        Class.forName(DB_DRIVER);
        Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        PreparedStatement st = con.prepareStatement("select * from customer where username = ?");
        st.setString(1, key);
        ResultSet result = st.executeQuery();
        if (result.next())
            userExists = true;
        st.close();
        con.close();
        return userExists;
    }

    public boolean checkPassword() {
        return pass_tf.getText().equals(cps_tf.getText());
    }

    public void handleBckBtn(ActionEvent event) throws IOException {
        Main.sceneFactory("CustomerLoginPage");
        CustomerDashboardController.setCustomerName(un_tf.getText());

    }

//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        // Initialize any necessary logic or components
//    }
}
