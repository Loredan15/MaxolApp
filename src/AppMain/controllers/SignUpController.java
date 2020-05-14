package AppMain.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import AppMain.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import AppMain.conf.DatabaseHandler;

public class SignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField signUpLogin;

    @FXML
    private PasswordField signUpPass;

    @FXML
    private Button signUpRegisterButton;

    @FXML
    private TextField signUpFirsttName;

    @FXML
    private TextField signUpLastName;

    @FXML
    void initialize() {

        signUpRegisterButton.setOnAction(actionEvent ->signUpNewUser());

    }

    private void signUpNewUser() {

        DatabaseHandler dbHandler = new DatabaseHandler();
        String firstName = signUpFirsttName.getText();
        String lastName = signUpLastName.getText();
        String userName = signUpLogin.getText();
        String password = signUpPass.getText();

        User user = new User(firstName, lastName, userName, password);

        dbHandler.signUpUser(user);

    }
}


