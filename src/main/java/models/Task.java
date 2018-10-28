package main.java.models;

import main.java.SQLiteHelper;

public class Task {

    int id;
    String task;

    public Task (int id, String task) {
        this.id = id;
        this.task = task;
    }

    public static void save(String task, SQLiteHelper helper) {
        helper.insert(task);
    }

    public static void getAllData() {}

}
