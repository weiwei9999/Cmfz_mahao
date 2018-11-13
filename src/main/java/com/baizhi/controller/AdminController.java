package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/user")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/login")
    public String login(Admin admin,HttpServletRequest request,String code){
        System.out.println(code);
        HttpSession session=request.getSession();
        String validationCode = (String) session.getAttribute("validationCode");
        System.out.println(validationCode);
        Admin admin1 = adminService.findlogin(admin);
        if(validationCode.equals(code)){
            if(admin1 !=null&&admin1.getUsername().length()>0&&admin1.getPassword().length()>0) {
                request.getSession().setAttribute("admin", admin1);
                return "redirect:/main/main.jsp ";
            }
            else{
                return "redirect:/back/login.jsp";
            }
        }else{
            return "redirect:/back/login.jsp";

        }

    }

    @RequestMapping("/remove")
    public String remove(HttpServletRequest request){
        request.getSession().setAttribute("admin",null);
        return "redirect:/back/login.jsp";
    }


    @RequestMapping("/update")
    public String update(Admin admin) {
        System.out.println(admin);
        adminService.motify(admin);
        return "redirect:/back/login.jsp";
    }

}
