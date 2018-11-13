package com.baizhi.controller;



import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
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
/*
* 轮播图操作（增删改查）
* */

@Controller
@RequestMapping("/banner")
public class BannerController {
    @Autowired
    private BannerService bannerService;

    @RequestMapping("/findAll")
    public @ResponseBody
    List<Banner> findAll() {
        List<Banner> serviceAll = bannerService.findAll();
        return serviceAll;
    }


    @RequestMapping("/add")
    public @ResponseBody
    Map<String, Object> save(Banner banner,HttpSession session,MultipartFile wei) {
        Map<String, Object> results = new HashMap<String, Object>();
        try {
            String img = session.getServletContext().getRealPath("/img");
            wei.transferTo(new File(img + "/" + wei.getOriginalFilename()));
            banner.setImgpth("/img/"+wei.getOriginalFilename());
            bannerService.add(banner);
            results.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success", false);
            results.put("message", e.getMessage());
        }
        return results;
    }

    @RequestMapping("/delete")
    public @ResponseBody
    void delete(Integer[] id) {
        for (int i = 0; i < id.length; i++) {
            bannerService.remove(id[i]);
        }

    }


    @RequestMapping("/update")
            public @ResponseBody
            Map<String, Object> update(Banner banner,HttpSession session,MultipartFile wei) {
                Map<String, Object> results = new HashMap<String, Object>();
                try {
                    String img = session.getServletContext().getRealPath("/img");
                    wei.transferTo(new File(img + "/" + wei.getOriginalFilename()));
                    banner.setImgpth("/img/"+wei.getOriginalFilename());
                    bannerService.motify(banner);
                    results.put("success", true);
                } catch (Exception e) {
                    e.printStackTrace();
            results.put("success", false);
            results.put("message", e.getMessage());
        }
        return results;
    }


    @RequestMapping("/queryone")
    public @ResponseBody
    Banner queryone(Integer id) {
        System.out.println(id);
        Banner banner = bannerService.fiandOne(id);
        System.out.println(banner);
        return banner;
    }


/*    //文件上传
    @RequestMapping("/upload")
    @ResponseBody
    public void upload(MultipartFile wei, HttpServletRequest request, Banner banner) throws IOException {
         System.out.println("原始文件名: " + wei.getOriginalFilename());
        //获取上传路径  相对路径 files    获取绝对路径
        String realPath = request.getSession().getServletContext().getRealPath("/img");
        //上传
        wei.transferTo(new File(realPath + "/" + wei.getOriginalFilename()));
        banner.setTitle(wei.getOriginalFilename());
        banner.setImgpth("img/" + wei.getOriginalFilename());
        System.out.println(banner);
        bannerService.add(banner);

    }*/
}





