package com.baizhi.service;

import com.baizhi.dao.ChapterDao;
import com.baizhi.entity.Chapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class ChapterServiceImpl implements ChapterService {
    @Autowired
    private ChapterDao chapterDao;
    @Override
    public void add(Chapter chapter) {
            chapterDao.insert(chapter);
    }

    @Override
    public Chapter fiandOne(int id) {
        return chapterDao.queryOne(id);
    }

    @Override
    public Chapter finadAlbumid(int albumid) {
        return chapterDao.queryAlbumid(albumid);
    }

    @Override
    public List<Chapter> findAll() {
        return chapterDao.queryAll();
    }
}
