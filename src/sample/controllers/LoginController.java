package sample.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button authButton;

    @FXML
    private Button SignUpButton;

    @FXML
    void initialize() {
        SignUpButton.setOnAction(actionEvent -> {
            SignUpButton.getScene().getWindow().hide();

            //Переключение активного окна
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/view/signUp.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
            //--------------------------------

            authButton.setOnAction(actionEvent1 -> {
                String loginText = loginField.getText().trim();
                String loginPass = passwordField.getText().trim();

                if(!loginText.equals("") && !loginPass.equals("")){
                    loginUser(loginText, loginPass);
                }
                else{
                    System.out.println("Login and password is empty");
                }
            });

        });

    }

    private void loginUser(String loginText, String loginPass) {
    }
}

