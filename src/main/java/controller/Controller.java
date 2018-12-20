package main.java.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.*;

public class MainController implements Initializable {

    @FXML
    private Button ui_one;

    @FXML
    private Button ui_two;

    @FXML
    private Button ui_three;

    @FXML
    private Button ui_four;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // ui_one button click event
        ui_one.setOnAction((m) -> {
            System.out.println("Mouse pressed");
        });

        // ui_one button click event
        ui_two.setOnAction((m) -> {
            System.out.println("Mouse pressed");
        });

        // ui_one button click event
        ui_three.setOnAction((m) -> {
            System.out.println("Mouse pressed");
        });

        // ui_one button click event
        ui_four.setOnAction((m) -> {
            System.out.println("Mouse pressed");
        });

    }

}
