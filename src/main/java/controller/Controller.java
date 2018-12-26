package main.java.controller;

import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXSnackbar;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class Controller implements Initializable {

    @FXML
    private Button ui_one, ui_two, ui_three, ui_four;

    @FXML
    private BorderPane borderPane;

    @FXML
    private StackPane stackPane;

    private JFXSnackbar snackbar;

    private double x, y;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ui_loader("fragment_ui_one");
        change_button_color(ui_one);
        snackbar = new JFXSnackbar(borderPane);
    }

    // Tab control starts here
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
        b.setStyle("-fx-background-color: #404040; -fx-text-fill: #FF4E3C; -fx-border-color: #FF4E3C");
    }

    // title bar control starts here
    @FXML
    private void dragged(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setX(event.getScreenX() - x);
        stage.setY(event.getScreenY() - y);
    }

    @FXML
    private void pressed(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();
    }

    @FXML
    private void close(MouseEvent event) {

        JFXDialogLayout dialogLayout = new JFXDialogLayout();
        Button dialogPositiveButton = new Button();
        Button dialogNegativeButton = new Button();
        JFXDialog dialog = new JFXDialog(stackPane, dialogLayout, JFXDialog.DialogTransition.TOP);

        // setting text and button to the dialog
        dialogLayout.setBody(new Text("Are you sure about closing the window?"));
        dialogPositiveButton.setText("Yes");
        dialogPositiveButton.getStyleClass().add("bg-white");
        dialogPositiveButton.getStyleClass().add("text-blue");
        dialogNegativeButton.setText("No");
        dialogNegativeButton.getStyleClass().add("bg-white");
        dialogNegativeButton.getStyleClass().add("text-blue");
        dialogLayout.setActions(dialogPositiveButton, dialogNegativeButton);

        // click listener for the button
        dialogPositiveButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent m) -> {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
        });
        dialogNegativeButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent m) -> {
            dialog.close();
        });

        dialog.show();

    }

    @FXML
    private void maximize(MouseEvent event) {
        snackbar.show("This is the max size.", 5000);
    }

    @FXML
    private void minimize(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

}
