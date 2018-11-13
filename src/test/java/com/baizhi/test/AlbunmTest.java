package com.baizhi.test;

import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class AlbunmTest extends BasicTest {

    @Autowired
    private AlbumService albumService;


@Test
    public void queryAllTest(){
        List<Album> list = albumService.findAll();
        for (Album list1 : list) {
            System.out.println(list1);

        }
    }

    @Test
    public void insertAlbum(){
        Album album =new Album();
        album.setTitle("ss");
        album.setCoverimg("ss");
        album.setScore(1);
        album.setCount(1);
        album.setAuthor("ss");
        album.setBroadcast("ss");
        album.setBrief("ss");
        album.setPublishdate(new Date());
        albumService.addAlbum(album);
    }

    @Test
    public void queryOne(){
        Album album=albumService.findOne(1);
        System.out.println(album);
    }


}
