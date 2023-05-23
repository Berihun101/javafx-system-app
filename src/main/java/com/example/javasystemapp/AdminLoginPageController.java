package com.example.javasystemapp;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;

public class AdminLoginPageController implements Initializable {
    static String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    static String DB_URL = "jdbc:mysql://localhost/sims";
    static String DB_USER = "root";
    static String DB_PASS = "";
    
    @FXML
    private Hyperlink goToCreate;

    @FXML
    private Label lblErrorMessage, lblSuccessMessage;

    @FXML
    private PasswordField tfPassword;
    @FXML private ImageView eyeIcon;

    @FXML
    private TextField tfUsername, tfPassword1;
    
    static String adminUsername;
    @FXML
    public void clear() {
        tfUsername.setText("");
        tfPassword.setText("");
        lblErrorMessage.setText("");
        lblSuccessMessage.setText("");
    }
    @FXML
    public void goBackToHome() throws IOException {
        Main.sceneFactory("MainPage");
    }
    @FXML
    public void goToCreate() throws IOException {
        System.out.println("Create");
    }

    @FXML
    public void login() throws IOException, ClassNotFoundException, SQLException {
        adminUsername = tfUsername.getText();
        String password = tfPassword.getText();
        boolean isValid = searchUser(adminUsername, password);
        Log.adminLoginAttempt(adminUsername, isValid);
        if (searchUser(adminUsername, password)) {
            Main.sceneFactory("/com/example/javasystemapp/AdminDashboard");
        }
        else 
            lblErrorMessage.setText("Incorrect Username or Password!");
    }
    
    public boolean searchUser(String userKey, String passKey) throws ClassNotFoundException, SQLException  {
        boolean isValidUser = false;
        String query = "SELECT * FROM admin WHERE username=? AND password=?";
        Class.forName(DB_DRIVER);
        Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, userKey);
        preparedStatement.setString(2, passKey);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) 
            isValidUser = true;
        return isValidUser;
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tfPassword1.setManaged(false);
        tfPassword1.setVisible(false);
        tfPassword1.textProperty().bindBidirectional(tfPassword.textProperty());  
        eyeIcon.setPickOnBounds(true);
        eyeIcon.setOnMouseClicked(event -> {
        if (event.getButton().equals(MouseButton.PRIMARY)) {
            if (tfPassword.isVisible()) {
                tfPassword.setManaged(false);
                tfPassword.setVisible(false);
                tfPassword1.setManaged(true);
                tfPassword1.setVisible(true);
            } else {
                tfPassword1.setManaged(false);
                tfPassword1.setVisible(false);
                tfPassword.setManaged(true);
                tfPassword.setVisible(true);
                }
            }
        });
    }        
}
