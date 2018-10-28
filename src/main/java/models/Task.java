package main.java.models;

import main.java.SQLiteHelper;
import java.util.ArrayList;

public class Task {

    private int id;
    private String task;

    public Task (int id, String task) {
        this.id = id;
        this.task = task;
    }

    public int getId() {
        return id;
    }

    public String getTask() {
        return task;
    }

    public void remove(SQLiteHelper helper) {
        helper.delete(this.id);
    }

    public static void save(String task, SQLiteHelper helper) {
        helper.insert(task);
    }

    public static ArrayList<Task> getAllData(SQLiteHelper helper) {
        return helper.select();
    }

}
