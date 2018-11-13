package com.baizhi.test;

import com.baizhi.entity.Menu;
import com.baizhi.service.MenuService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MenuTest extends BasicTest {
    @Autowired
    private MenuService menuService;

    @Test
    public void findALL() {
        List<Menu> list = menuService.findAll();
        for (Menu list1 : list) {
            System.out.println(list1);
            for (Menu menu : list) {
                System.out.println(menu);
            }
        }

    }
}