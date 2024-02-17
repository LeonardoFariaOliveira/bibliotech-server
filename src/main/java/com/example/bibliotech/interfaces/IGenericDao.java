package com.example.bibliotech.interfaces;

import java.util.List;

public interface IGenericDao<T> {
    public void create(T object);
    public List<T> getAll();
    public T getOneById(int id);
    public void update(int id, T object);
    public void delete(int id);
}
