package com.mycompany.databaseproject.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseHelper {

    private static Connection connect = null;
    private static final String URL = "jdbc:sqlite:D-Coffee.db";

//When class call this static will start connect to db
    static {
        getConnect();
    }

    public static synchronized Connection getConnect() {
        if (connect == null) {
            try {
                connect = DriverManager.getConnection(URL);
                System.out.println("Connection to SQLite has been estblish.");
            } catch (SQLException ex) {
                System.out.println("Already connect to Database");
            }
        }
        return connect;
    }

//Close connection to db
    public static synchronized void close() {
        if (connect != null) {
            try {
                connect.close();
                connect = null;
                System.out.println("Connection to SQLite has been close.");
            } catch (SQLException ex) {
                System.out.println("Connection to SQLite has been close.");
            }
        }
    }

    //Insert
    public static synchronized int getInsertedID(Statement stmt) {
        try {
            ResultSet key = stmt.getGeneratedKeys();
            key.next();
            return key.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
}
