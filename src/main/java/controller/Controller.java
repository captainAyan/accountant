package main.java.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.*;

public class Controller implements Initializable {

    @FXML
    private JFXListView<String> task_list_view;

    @FXML
    private JFXButton add_btn;

    @FXML
    private JFXTextField task_name;

    private ObservableList<String> task_list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*for (int i = 0; i < 4; i++) {
            Label item = new Label("title " + i);
            task_list_view.getItems().add(item);

            item.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    showPopup();
                }
            });
        }*/

        task_list.addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                // list changed
            }
        });

        task_list_view.setItems(task_list);

        task_list_view.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                System.out.println(task_list_view.getSelectionModel().getSelectedIndices() + "");
            }
        });

    }




    // onclick add button
    @FXML
    void addDate(ActionEvent event) {
        if (!task_name.getText().equals("")) {
            task_list.add(task_name.getText());
            task_name.setText("");
        }
    }

    void showPopup() {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/main/resource/view/confirmation.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage confirmationStage = new Stage();

            confirmationStage.setTitle("Ayan's Todo");
            confirmationStage.setScene(new Scene(root1));
            confirmationStage.setResizable(false);
            confirmationStage.getIcons().add(new Image("/main/resource/image/icon.png"));
            confirmationStage.show();

        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
