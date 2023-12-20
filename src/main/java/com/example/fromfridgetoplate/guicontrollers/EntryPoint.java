package com.example.fromfridgetoplate.guicontrollers;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class EntryPoint extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Navigator navigator = Navigator.getInstance(stage);
        navigator.setMainPage("mainPage6.fxml");
    }

    public static void main(String[] args) {
        launch();
    }
}
