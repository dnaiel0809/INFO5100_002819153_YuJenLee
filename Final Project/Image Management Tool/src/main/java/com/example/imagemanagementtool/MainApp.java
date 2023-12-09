package com.example.imagemanagementtool;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {

        MainUI mainUI = new MainUI();


        primaryStage.setTitle("Image Converter App");
        primaryStage.setScene(new Scene(mainUI, 800, 600));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}