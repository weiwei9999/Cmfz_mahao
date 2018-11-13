package com.baizhi.test;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AdminTest extends BasicTest {
    @Autowired
    private AdminService adminService;

@Test
    public void  queryTest(){
    Admin admin =new Admin();
    admin.setUsername("123");
    admin.setPassword("112311");
    Admin admin1 = adminService.findlogin(admin);
    if(admin1 !=null){
        System.out.println(true);
    }else{
        System.out.println(false);
    }
    }

    @Test
    public void updateTest(){
        Admin admin =new Admin();
        admin.setId(1);
        admin.setUsername("123");
        admin.setPassword("520");
      adminService.motify(admin);
    }

    @Test
    public  void deletelTest(){
        adminService.remove(1);
    }

}