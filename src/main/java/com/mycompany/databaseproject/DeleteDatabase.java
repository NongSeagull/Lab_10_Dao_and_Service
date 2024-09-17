package com.mycompany.databaseproject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteDatabase {
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

        //Delete Data
        String sql = "DELETE FROM catagory WHERE catagory_ID = ?";
        try {
            PreparedStatement stmt = connect.prepareStatement(sql);
            stmt.setInt(1, 4);
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
