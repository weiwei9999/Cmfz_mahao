package com.baizhi.dao;

import com.baizhi.entity.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseDao<T> {
    void insert(T t);

    void update(T t);

    void delete(int id);

    T queryOne(int id);

    T query(T t);

    List<T> queryAll();

    List<T> queryByPage(@Param("start") Integer start, @Param("rows") Integer rows);

    Long queryTotals();
}
