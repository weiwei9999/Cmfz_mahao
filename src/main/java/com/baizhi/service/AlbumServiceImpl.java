package com.baizhi.service;

import com.baizhi.dao.AlbumDao;
import com.baizhi.entity.Album;
import com.baizhi.entity.Chapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional

public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumDao albumDao;

    @Override
    public void addAlbum(Album album) {
        albumDao.insert(album);
    }

    @Override
    public Album findOne(int id) {
        return albumDao.queryOne(id);
    }

 /*@Override
    public void addChapter(Chapter chapter) {
        albumDao.insert(chapter);
    }*/

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Album> findAll(){
        return albumDao.queryAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Album> findByPage(Integer page, Integer rows) {
        int start =(page-1)*rows;
        return albumDao.queryByPage(start,rows);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Long findTotals() {
        return albumDao.queryTotals();
    }
    }

