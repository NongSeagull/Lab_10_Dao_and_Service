package com.mycompany.databaseproject.dao;

import java.util.ArrayList;

public interface Dao<T> {

    T getByID(int id);

    T getByName(String name);

    ArrayList<T> getAll();

    T save(T obj);

    T update(T obj);

    int delete(T obj);

    ArrayList<T> getAll(String where, String order);
}
