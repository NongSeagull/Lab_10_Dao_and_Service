package com.mycompany.databaseproject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SelectDatabase {
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

        //Selection all elements
        String sql = "SELECT * FROM catagory";
        try {
            Statement stmt = connect.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println(rs.getInt("catagory_ID") + " "
                        + rs.getString("catagory_name"));
            }

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
