package com.example.fromfridgetoplate.guicontroller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Navigator navigator = Navigator.getInstance(stage);
        navigator.setLoginPage("LoginPage.fxml");
    }

    public static void main(String[] args) {
        launch();
    }
}
