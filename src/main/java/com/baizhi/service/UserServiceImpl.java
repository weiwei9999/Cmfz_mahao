package com.baizhi.service;

import com.baizhi.dao.UserDao;

import com.baizhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class UserServiceImpl implements  UserService{
    @Autowired
    private UserDao userDao;

    @Override
    public void add(User user) {
        userDao.insert(user);
    }

    @Override
    public void remove(int id) {
     userDao.delete(id);
    }

    @Override
    public void motify(User user) {
    userDao.update(user);
    }

    @Override
    public User fiandOne(int id) {
        return userDao.queryOne(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.queryAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<User> findByPage(Integer page, Integer rows) {
        int start =(page-1)*rows;
        return userDao.queryByPage(start,rows);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Long findTotals() {
        return userDao.queryTotals();
    }

}
