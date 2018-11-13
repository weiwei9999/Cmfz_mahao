package com.baizhi.controller;


import com.baizhi.entity.User;
import com.baizhi.service.UserService;
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
@RequestMapping("/User")
public class UserController {
        @Autowired
        private UserService userService;

        @RequestMapping("/findAll")
        public @ResponseBody
        List<User> findAll() {
            List<User> serviceAll = userService.findAll();
            return serviceAll;
        }


        @RequestMapping("/add")
        public @ResponseBody
        Map<String, Object> save(User user, HttpSession session, MultipartFile wei) {
            Map<String, Object> results = new HashMap<String, Object>();
            try {
                String img = session.getServletContext().getRealPath("/img");
                wei.transferTo(new File(img + "/" + wei.getOriginalFilename()));
                user.setPhone("/img/"+wei.getOriginalFilename());
                userService.add(user);
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
                userService.remove(id[i]);
            }

        }


        @RequestMapping("/update")
        public @ResponseBody
        Map<String, Object> update(User user, HttpSession session, MultipartFile wei) {
            Map<String, Object> results = new HashMap<String, Object>();
            try {
                String img = session.getServletContext().getRealPath("/img");
                wei.transferTo(new File(img + "/" + wei.getOriginalFilename()));
                user.setPhone("/img/"+wei.getOriginalFilename());
                userService.motify(user);
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
        User queryone(Integer id) {
            User user = userService.fiandOne(id);
            return user;
        }
}
