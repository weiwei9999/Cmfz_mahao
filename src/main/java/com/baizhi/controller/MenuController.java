package com.baizhi.controller;

import com.baizhi.entity.Menu;
import com.baizhi.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/menu")

public class MenuController {
    @Autowired
    private MenuService menuService;
    @RequestMapping("/findAll")
    @ResponseBody
    public Map<String,Object> findAll(){
        Map<String,Object> map = new HashMap<String,Object>();
        try{
            List<Menu> all = menuService.findAll();
            map.put("menus",all);
            map.put("success",true);

        }catch(Exception e){
            e.printStackTrace();
            map.put("success",false);
        }

        return map;
    }

}

