package com.example.vocaboost.service;

import java.util.List;

public interface IGenerateService<T> {
    List<T> findAll();
    T findById(int id);
    T save(T entity);
    void deleteById(int id);
}
