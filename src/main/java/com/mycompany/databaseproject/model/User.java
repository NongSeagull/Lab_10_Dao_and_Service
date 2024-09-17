package com.mycompany.databaseproject.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class User {

    private int ID;
    private String name;
    private String password;
    private int role;
    private String gender;

    public User() {
        this.ID = -1;
        this.name = "unknown";
        this.password = null;
        this.role = 0;
        this.gender = "unknown";
    }

    public User(String name, String password, int role, String gender) {
        this.ID = -1;
        this.name = name;
        this.password = password;
        this.role = role;
        this.gender = gender;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "ID : " + ID + " | " + "User :" + name + " | " + "Password : " + password + " | "
                + "\nRole : " + role + "\nGender : " + gender
                + "\n=========================================================\n";
    }

    public void fromResultSet(ResultSet result) {
        try {
            this.setID(result.getInt("user_ID"));
            this.setName(result.getString("user_name"));
            this.setGender(result.getString("user_gender"));
            this.setPassword(result.getString("user_password"));
            this.setRole(result.getInt("user_role"));
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
