package com.baizhi.controller;


import com.baizhi.entity.Banner;
import com.baizhi.entity.Guru;
import com.baizhi.service.GuruService;
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
@RequestMapping("/guru")
public class GuruController {
    @Autowired
    private GuruService guruService;
    @RequestMapping("/findAll")
    public @ResponseBody
    Map<String, Object> findAll(Integer page, Integer rows) {
        Map<String, Object> results = new HashMap<String, Object>();
        //当前页数据rows:
        List<Guru> gurus = guruService.findByPage(page, rows);
        //总记录数
        Long totals = guruService.findTotals();
        System.out.println(totals);
        results.put("total", totals);
        results.put("rows", gurus);
        return results;
    }

    @RequestMapping("/add")
    public @ResponseBody
    Map<String, Object> save(Guru guru, HttpSession session, MultipartFile wei) {
        Map<String, Object> results = new HashMap<String, Object>();
        try {
            String img = session.getServletContext().getRealPath("/img");
            wei.transferTo(new File(img + "/" + wei.getOriginalFilename()));
            guru.setHeadpic("/img/"+wei.getOriginalFilename());
            guruService.add(guru);
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
            guruService.remove(id[i]);
        }
    }



}
