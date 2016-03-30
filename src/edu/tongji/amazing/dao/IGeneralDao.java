package edu.tongji.amazing.dao;

import java.util.List;

public interface IGeneralDao<T> {
	T queryById(String id);

    T queryByIntId(int id);

    List<T> queryAll();
    void insert(T t);
    void delete(T t);
    void update(T t);
}
