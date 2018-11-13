package com.baizhi.service;

import com.baizhi.entity.Album;
import com.baizhi.entity.Chapter;


import java.util.List;

public interface AlbumService {


    //添加专辑
    void addAlbum(Album album);

    Album findOne(int id);
    //添加章节
   /*void addChapter(Chapter chapter);*/
    //查所有专辑
    List<Album> findAll();

    List<Album> findByPage(Integer page, Integer rows);

    Long findTotals();
}

