
import java.io.IOException;
import java.net.URL;

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
        Main.sceneFactory("hello-view");
    }
    @FXML
    public void goToCreate() throws IOException {
        System.out.println("Create");
    }

    @FXML
    public void login() throws IOException {
        adminUsername = tfUsername.getText();
        Log.adminLoginAttempt(adminUsername);
        String password = tfPassword.getText();
        if (searchUser(adminUsername, password)) {
            System.out.println("Logged in");
        }
        else 
            lblErrorMessage.setText("Incorrect Username or Password!");
    }
    
    public boolean searchUser(String userKey, String passKey)  {
        boolean isValidUser = false;
        if (passKey == "123")
            if (userKey == "Mekdem" || userKey == "Fekadu" || userKey == "Berihun")
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
