package AppMain.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import AppMain.User;
import AppMain.conf.DatabaseHandler;
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
                    loader.setLocation(getClass().getResource("/AppMain/view/signUp.fxml"));
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
                });

            authButton.setOnAction(actionEvent1 -> {
                String loginText = loginField.getText().trim();
                String loginPass = passwordField.getText().trim();

                if (!loginText.equals("") && !loginPass.equals("")) {
                    loginUser(loginText, loginPass);
                } else {
                    System.out.println("Login and password is empty");
                }
            });

    }

    private void loginUser(String loginText, String loginPass) {
        DatabaseHandler dbHandler = new DatabaseHandler();
        User user = new User();
        user.setUserName(loginText);
        user.setPassword(loginPass);
        ResultSet result = dbHandler.getUser(user);

        int counter = 0;
        try {
            while (result.next()) {
                counter++;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        if(counter >= 1){
            System.out.println("login success !");

            SignUpButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/AppMain/view/app.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        }
    }
}

