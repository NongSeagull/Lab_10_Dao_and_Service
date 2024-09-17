package com.mycompany.databaseproject.service;

import com.mycompany.databaseproject.dao.UserDao;
import com.mycompany.databaseproject.model.User;

public class UserService {

    public User login(String name, String password) {
        UserDao userDao = new UserDao();
        User user = userDao.getByName(name);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
