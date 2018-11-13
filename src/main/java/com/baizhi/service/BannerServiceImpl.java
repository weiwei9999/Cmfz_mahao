package com.baizhi.service;

import com.baizhi.dao.BannerDao;
import com.baizhi.entity.Banner;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional

public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerDao bannerDao;
    @Override
    public void add(Banner banner) {
        bannerDao.insert(banner);
    }

    @Override
    public void remove(int id) {
        bannerDao.delete(id);
    }

    @Override
    public void motify(Banner banner) {
        bannerDao.update(banner);
    }

    @Override
    @Transactional(propagation=Propagation.SUPPORTS)
    public Banner fiandOne(int id) {
        return bannerDao.queryOne(id);
    }

    @Override
    @Transactional(propagation=Propagation.SUPPORTS)
    public List<Banner> findAll() {
        return bannerDao.queryAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Banner> findByPage(Integer page, Integer rows) {
        int start =(page-1)*rows;
        return bannerDao.queryByPage(start,rows);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Long findTotals() {
        return bannerDao.queryTotals();
    }


}

