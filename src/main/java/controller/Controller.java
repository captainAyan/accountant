package main.java.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class Controller implements Initializable {

    @FXML
    private Button ui_one;

    @FXML
    private Button ui_two;

    @FXML
    private Button ui_three;

    @FXML
    private Button ui_four;

    @FXML
    private BorderPane borderPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ui_loader("fragment_ui_one");
    }

    @FXML
    void ui_one(MouseEvent event) {
        ui_loader("fragment_ui_one");
        change_button_color(ui_one);
    }

    @FXML
    void ui_two(MouseEvent event) {
        ui_loader("fragment_ui_two");
        change_button_color(ui_two);
    }

    @FXML
    void ui_three(MouseEvent event) {
        ui_loader("fragment_ui_three");
        change_button_color(ui_three);
    }

    @FXML
    void ui_four(MouseEvent event) {
        ui_loader("fragment_ui_four");
        change_button_color(ui_four);
    }

    private void ui_loader(String ui) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/main/resource/view/fragments/"+ui+".fxml"));
            borderPane.setCenter(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void change_button_color(Button b) {
        ui_one.setStyle("-fx-background-color: transparent; -fx-text-fill: #f0f0f0;");
        ui_two.setStyle("-fx-background-color: transparent; -fx-text-fill: #f0f0f0;");
        ui_three.setStyle("-fx-background-color: transparent; -fx-text-fill: #f0f0f0;");
        ui_four.setStyle("-fx-background-color: transparent; -fx-text-fill: #f0f0f0;");
        b.setStyle("-fx-background-color: #404040; -fx-text-fill: #f0f0f0;");
    }

}
