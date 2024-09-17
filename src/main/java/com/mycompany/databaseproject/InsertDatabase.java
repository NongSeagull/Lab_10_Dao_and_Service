package com.mycompany.databaseproject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

public class InsertDatabase {
    public static void main(String[] args) {
        Connection connect = null;
        String url = "jdbc:sqlite:D-Coffee.db";

        //Connection database
        try {
            connect = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been estblish.");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return;
        }

        //Insert elements
        String sql = "INSERT INTO catagory(catagory_ID, catagory_name) VALUES (?, ?)";
        /*String sql = "INSERT INTO catagory( catagory_name) VALUES ('Candy')";*/
        try {
            //Solution 1
            /*Statement stmt = connect.createStatement();
            int status = stmt.executeUpdate(sql);
            //For get Index
            ResultSet key = stmt.getGeneratedKeys();
            key.next();
            System.out.println("Key : " + key.getInt(1));
            */
            
            //Solution 2
            PreparedStatement stmt = connect.prepareStatement(sql);
            stmt.setInt(1, 4);
            stmt.setString(2, "Sweets");
            int status = stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return;
        }

        //Close Database
        if (connect != null) {
            try {
                connect.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
