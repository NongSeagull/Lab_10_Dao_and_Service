package com.mycompany.databaseproject.dao;

import com.mycompany.databaseproject.helper.DatabaseHelper;
import com.mycompany.databaseproject.model.User;

public class TestUserDao {

    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        /* for (User u : userDao.getAll()) {
            System.out.println(u);
        }*/
        User user1 = userDao.getByID(3);
        System.out.println(user1);

        /*   User newUser = new User("user3", "123abc", 2, "F");
        User insertedUser = userDao.save(newUser);
        System.out.println(insertedUser);
       
        insertedUser.setGender("M");*/
        user1.setGender("F");
        userDao.update(user1);
        User updateUser = userDao.getByID(user1.getID());
        System.out.println(updateUser);

        for (User u : userDao.getAll(" user_name LIKE 'u%'", "user_name asc, user_gender desc")) {
            System.out.println(u);
        }

        DatabaseHelper.close();
    }
}
