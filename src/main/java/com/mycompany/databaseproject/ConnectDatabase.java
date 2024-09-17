package com.mycompany.databaseproject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectDatabase {
    public static void main(String[] args) {
        Connection connect = null;
        String url = "jdbc:sqlite:D-Coffee.db";
        try {
            connect = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been estblish.");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }
}
