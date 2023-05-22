package com.example.javasystemapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;
import static javafx.application.Application.launch;

public class Main extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("/com/example/javasystemapp/MainPage"));
        stage.setTitle("System App!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    public static void sceneFactory(String fxml) throws IOException{
        scene.setRoot(loadFXML(fxml));
        scene.getWindow().sizeToScene();
    }
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        return loader.load(Main.class.getResource(fxml+".fxml"));
    }



}