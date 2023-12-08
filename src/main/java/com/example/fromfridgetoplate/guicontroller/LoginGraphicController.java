package com.example.fromfridgetoplate.guicontroller;

import com.example.fromfridgetoplate.logic.bean.UserBean;
import com.example.fromfridgetoplate.logic.control.LoginController;
import com.example.fromfridgetoplate.logic.model.Role;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginGraphicController implements Initializable {
    @FXML
    private Button loginButton;
    @FXML
    private TextField emailText;
    @FXML
    private PasswordField pwdText;

    Navigator navigator = Navigator.getInstance(null);

    @Override
    public void initialize(URL location,
                           ResourceBundle resources) {
        loginButton.setOnMouseClicked(event -> {
            UserBean loggedUser;

            if (emailText.getText().isEmpty() || pwdText.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Complete the field before!");
                alert.showAndWait();
                return;
            }
            else {
                UserBean userBean = new UserBean(emailText.getText(), pwdText.getText());
                LoginController loginController = new LoginController();
                loggedUser = loginController.login(userBean);
            }
            try {

                if(loggedUser.getRole() == Role.CLIENT) {
                    navigator.goTo("homePage.fxml");
                }
                if(loggedUser.getRole() == Role.RIDER) {
                    /* goto rider homepage*/
                }
                if(loggedUser.getRole() == Role.OWNER){
                    /* goto shop owner homepage*/
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
