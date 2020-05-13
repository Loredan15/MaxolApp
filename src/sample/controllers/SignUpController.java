package sample.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.conf.DatabaseHandler;

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

        DatabaseHandler dbHandler = new DatabaseHandler();
        signUpRegisterButton.setOnAction(actionEvent -> dbHandler.signUpUser(signUpFirsttName.getText(), signUpLastName.getText(), signUpLogin.getText(), signUpPass.getText()));

    }
}


