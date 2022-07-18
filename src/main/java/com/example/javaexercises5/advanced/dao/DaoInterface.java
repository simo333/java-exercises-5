package com.example.javaexercises5.advanced.dao;

import java.util.List;

public interface DaoInterface {

    List<Model> loadAll();

    Model loadById(int id);

    void save(Model object);

    void delete(Model object);

}

