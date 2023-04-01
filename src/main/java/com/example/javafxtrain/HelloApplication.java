package com.example.javafxtrain;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.paint.Color.PINK;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage){
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 1200, 900, Color.LIGHTBLUE);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // scene.setFill();
        stage.setTitle("Hello!");
        stage.setScene(scene);
        //Pane operationPane = fxmlLoader.getController().
       //fxmlLoader.getRoot().
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}