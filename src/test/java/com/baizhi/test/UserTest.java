package com.baizhi.test;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserTest  extends  BasicTest{
    @Autowired
    private UserService userService;
    @Test
    public void queryUser(){

        List<User> list = userService.findAll();
        for (User list1 : list) {
            System.out.println(list1);

        }
    }

}
