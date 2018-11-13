package com.baizhi.service;

import com.baizhi.entity.Guru;
import com.baizhi.entity.User;

import java.util.List;

public interface UserService  {
    void add(User user);

    void remove(int id);

    void motify(User user);

    User fiandOne(int id);

    List<User> findAll();

    List<User> findByPage(Integer page, Integer rows);

    Long findTotals();
}
