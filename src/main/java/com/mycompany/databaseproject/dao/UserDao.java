package com.mycompany.databaseproject.dao;

import com.mycompany.databaseproject.helper.DatabaseHelper;
import com.mycompany.databaseproject.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDao implements Dao<User> {

    @Override
    public User getByID(int id) {
        User user = null;
        String sql = "SELECT * FROM user WHERE user_ID = ?";
        Connection connect = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = connect.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                user = new User();
                user.fromResultSet(result);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return user;
    }

    @Override
    public User getByName(String name) {
        User user = null;
        String sql = "SELECT * FROM user WHERE user_name = ?";
        Connection connect = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = connect.prepareStatement(sql);
            stmt.setString(1, name);
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                user = new User();
                user.fromResultSet(result);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return user;
    }

    @Override
    public ArrayList<User> getAll() {
        ArrayList<User> userList = new ArrayList<>();
        String sql = "SELECT * FROM user";
        Connection connect = DatabaseHelper.getConnect();
        try {
            Statement stmt = connect.createStatement();
            ResultSet result = stmt.executeQuery(sql);

            while (result.next()) {
                User user = new User();
                user.fromResultSet(result);
                userList.add(user);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return userList;
    }

    @Override
    public ArrayList<User> getAll(String where, String order) {
        ArrayList<User> userList = new ArrayList<>();
        String sql = "SELECT * FROM user WHERE " + where + " ORDER BY " + order;
        System.out.println(sql);
        Connection connect = DatabaseHelper.getConnect();
        try {
            Statement stmt = connect.createStatement();
            ResultSet result = stmt.executeQuery(sql);

            while (result.next()) {
                User user = new User();
                user.fromResultSet(result);

                userList.add(user);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return userList;
    }

    @Override
    public User save(User obj) {
        String sql = "INSERT INTO user(user_name, user_gender, user_password, user_role)"
                + "VALUES (?, ?, ?, ?)";
        Connection connect = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = connect.prepareStatement(sql);
            stmt.setString(1, obj.getName());
            stmt.setString(2, obj.getGender());
            stmt.setString(3, obj.getPassword());
            stmt.setInt(4, obj.getRole());
            //System.out.println(stmt); -> log
            int ID = DatabaseHelper.getInsertedID(stmt);
            obj.setID(ID);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return obj;
    }

    @Override
    public User update(User obj) {
        String sql = "UPDATE user"
                + "   SET user_name = ?, user_gender = ?, user_password = ?, user_role = ?"
                + "   WHERE user_ID = ?;";
        Connection connect = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = connect.prepareStatement(sql);
            stmt.setString(1, obj.getName());
            stmt.setString(2, obj.getGender());
            stmt.setString(3, obj.getPassword());
            stmt.setInt(4, obj.getRole());
            stmt.setInt(5, obj.getID());
            //System.out.println(stmt); -> log
            stmt.executeUpdate();
            return obj;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public int delete(User obj) {
        String sql = "DELETE FROM user WHERE user_ID = ?";
        Connection connect = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = connect.prepareStatement(sql);
            stmt.setInt(1, obj.getID());
            int result = stmt.executeUpdate();
            return result;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return -1;
    }

}
