package com.mycompany.databaseproject.service;

import com.mycompany.databaseproject.model.User;

public class TestUserService {

    public static void main(String[] args) {
        UserService userService = new UserService();
        User user = userService.login("user1", "admin1150");
        if (user != null) {
            System.out.println("Welcome user : " + user.getName());
        } else {
            System.out.println("Error");
        }
    }
}
