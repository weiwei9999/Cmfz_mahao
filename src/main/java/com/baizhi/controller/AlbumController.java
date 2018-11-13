package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/album")
public class AlbumController {
    @Autowired
    private AlbumService albumService;


    @RequestMapping("/findAll")
    public @ResponseBody List<Album> showAll(){
        List<Album> list = albumService.findAll();
        for (Album a:list) {
            a.setCount(a.getChildren().size());
        }
        System.out.println(list);
        return list;
    }

    @RequestMapping("/add")
    public @ResponseBody
    Map<String, Object> save(Album album, HttpSession session, MultipartFile wei) {
        Map<String, Object> results = new HashMap<String, Object>();
        try {
            String img = session.getServletContext().getRealPath("/img");
            wei.transferTo(new File(img + "/" + wei.getOriginalFilename()));
            album.setCoverimg("/img/"+wei.getOriginalFilename());
           albumService.addAlbum(album);
            results.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success", false);
            results.put("message", e.getMessage());
        }
        return results;
    }

    @RequestMapping("/findone")
    public @ResponseBody Album findOne(Integer id, HttpSession session){
        Album album = albumService.findOne(id);
        session.setAttribute("wei",album.getCoverimg());
        return album;
    }

}
