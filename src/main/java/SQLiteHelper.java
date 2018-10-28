package main.java;

import main.java.models.Task;

import java.sql.*;
import java.util.ArrayList;

public class SQLiteHelper {

    Connection conn = null;

    // creates Connection
    public void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:test.db");
            System.out.println("Database connected");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // creates table if doesn't exist
    public void createNewTable() {
        String sql = "CREATE TABLE IF NOT EXISTS tasks (id integer PRIMARY KEY AUTOINCREMENT, task text NOT NULL);";
        try {
            // create a new table
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            System.out.println("Table is ready");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // inserts tasks to database
    public void insert(String task) {
        String sql = "INSERT INTO tasks(task) VALUES(?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, task);
            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    // select all tasks
    public ArrayList<Task> select() {
        String sql = "SELECT id, task FROM tasks";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            ArrayList<Task> resArr = new ArrayList<Task>();

            while (rs.next()) {
                resArr.add(new Task(rs.getInt("id"), rs.getString("task")) );
            }

            return resArr;

        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    public void delete(int id) {
        String sql = "DELETE FROM tasks WHERE id = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
