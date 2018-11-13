package com.baizhi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Controller
@RequestMapping("/handle")
public class AdminInterceptor implements HandlerInterceptor {
   @RequestMapping("/preHandle")
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
       Object os = request.getSession().getAttribute("admin");
		if(os==null){
			//跳转到登陆页面
			response.sendRedirect(request.getContextPath()+"/back/login.jsp");
			return false;
		}
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
