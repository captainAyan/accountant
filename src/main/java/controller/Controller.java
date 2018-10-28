package main.java.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXProgressBar;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import main.java.SQLiteHelper;
import main.java.models.Task;

import java.net.URL;
import java.util.*;

public class Controller implements Initializable {

    @FXML
    private JFXListView<String> task_list_view;
    @FXML
    private JFXButton add_btn;
    @FXML
    private JFXTextField task_name;

    private SQLiteHelper mSqLiteHelper;
    private ObservableList<String> task_list;
    private ArrayList<Task> tasks_array_list;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        task_name.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(final ObservableValue<? extends String> ov, final String oldValue, final String newValue) {
                if (task_name.getText().length() > 40) {
                    String s = task_name.getText().substring(0, 40);
                    task_name.setText(s);
                }
            }
        });

        // setting up database
        mSqLiteHelper = new SQLiteHelper();
        mSqLiteHelper.connect();
        mSqLiteHelper.createNewTable();

        // initializing observable list
        task_list = FXCollections.observableArrayList();

        setListView();

        // item click listener
        task_list.addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) { /*list changed*/ }
        });
        task_list_view.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (!task_list_view.getSelectionModel().getSelectedIndices().isEmpty()) {
                    tasks_array_list.get(task_list_view.getSelectionModel().getSelectedIndices().get(0)).remove(mSqLiteHelper);
                    setListView();
                }
            }
        });

    }


    // onclick add button
    @FXML
    void addData(ActionEvent event) {
        String task = task_name.getText();
        if (!task.equals("")) {
            Task.save(task, mSqLiteHelper);

            setListView();

            task_name.setText("");
        }
    }

    private void setListView() {

        try {
            task_list.clear();
            tasks_array_list.clear();
        }
        catch (Exception e) {}

        // getting all tasks in an array list
        tasks_array_list = Task.getAllData(mSqLiteHelper);

        // assigning data from array list to observable list
        tasks_array_list.forEach((task) -> {
            task_list.add(task.getTask());
        });

        // setting observable list view
        task_list_view.setItems(task_list);
    }

}
