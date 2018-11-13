package com.baizhi.test;

import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ChapterTest extends BasicTest {
    @Autowired
    private ChapterService chapterService;

    @Test
    public void queryAlbumid(){
        System.out.println(chapterService.finadAlbumid(4));
    }
    @Test
    public void findALL() {
        List<Chapter> list = chapterService.findAll();
        for (Chapter list1 : list) {
            System.out.println(list1);

        }
    }
}