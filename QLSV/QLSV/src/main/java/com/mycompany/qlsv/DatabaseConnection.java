package com.mycompany.qlsv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static String DB_URL = "jdbc:mysql://127.0.0.1:3306/student_management";
    private static String USER_NAME = "vietlong685572";
    private static String PASSWORD = "vietlong685572";
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }
    public static void main(String[] args){
        DatabaseConnection dbc = new DatabaseConnection();
        dbc.getConnection();
    }
}
