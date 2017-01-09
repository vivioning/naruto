package com.vivion.naruto.dao.base;

import java.util.List;

/**
 * Created by GuoXinJie on 2017-01-09.
 */
public interface DaoBase<T, K> {
    void add(T var1);

    int update(T var1);

    T get(T var1);

    T getById(K var1);

    List<T> query(T var1);

    int delete(K var1);

    int count(T var1);
}
