package com.baizhi.service;


import com.baizhi.entity.Guru;

import java.util.List;

public interface GuruService {
    void add(Guru guru);

    void remove(int id);

    void motify(Guru guru);

    Guru fiandOne(int id);

    List<Guru> findAll();

    List<Guru> findByPage(Integer page, Integer rows);

    Long findTotals();
}
