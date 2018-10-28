package main.java;

import java.sql.*;

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
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
