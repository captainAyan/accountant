package main.java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/main/resource/view/sample.fxml"));
        primaryStage.setTitle("Ayan's Todo");
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/main/resource/style/style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image("/main/resource/image/icon.png"));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
