package com.baizhi.service;

import com.baizhi.dao.GuruDao;
import com.baizhi.entity.Guru;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
@Service
@Transactional

public class GuruServiceImpl implements GuruService {
    @Autowired
    private GuruDao guruDao;

    @Override
    public void add(Guru guru) {
        guruDao.insert(guru);
    }

    @Override
    public void remove(int id) {
        guruDao.delete(id);
    }

    @Override
    public void motify(Guru guru) {
        guruDao.update(guru);
    }

    @Override
    public Guru fiandOne(int id) {
        return guruDao.queryOne(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Guru> findAll() {
        return guruDao.queryAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Guru> findByPage(Integer page, Integer rows) {
        int start =(page-1)*rows;
        return guruDao.queryByPage(start,rows);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Long findTotals() {
        return guruDao.queryTotals();
    }

}
