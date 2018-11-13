package com.baizhi.service;

import com.baizhi.entity.Banner;

import java.util.List;

public interface BannerService {
    void add(Banner banner);

    void remove(int id);

    void motify(Banner banner);

    Banner fiandOne(int id);

    List<Banner> findAll();

    List<Banner> findByPage(Integer page, Integer rows);

    Long findTotals();

}