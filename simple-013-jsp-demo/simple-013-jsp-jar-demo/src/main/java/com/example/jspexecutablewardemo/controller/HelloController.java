package com.example.jspexecutablewardemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Controller
public class HelloController {

    @RequestMapping("/")
    public ModelAndView hello(){
        ModelAndView mav = new ModelAndView("hello");
        mav.addObject("name", "world");
        return mav;
    }

    @GetMapping("/ajax/content")
    public void ajaxRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        //response.setContentType("text/html;charset=utf-8");
        //String userName = "何凯";
        //userName = request.getParameter("username");
        //userName = new String(userName.getBytes("ISO-8859-1"), "GB2312");
        //
        //String msg = "123";
        //if("admin".equals(userName)){
        //    log.info("admin user login");
        //    msg = "admin user";
        //}else{
        //    log.info("other user login");
        //    msg = "other user";
        //}
        response.getWriter().println("何凯");
    }
}