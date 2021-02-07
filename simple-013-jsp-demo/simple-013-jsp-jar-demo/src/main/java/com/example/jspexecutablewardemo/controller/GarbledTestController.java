package com.example.jspexecutablewardemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class GarbledTestController {

    @RequestMapping("/test")
    public String test(){
        return "GarbledTest";
    }

    @RequestMapping("/test1")
    public void test1(HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");

        PrintWriter printWriter = response.getWriter();
        printWriter.write("你好世界");

    }

    @GetMapping("/test2")
    public void test2(HttpServletRequest request){
        String name = request.getParameter("name");
        System.out.println(name);
    }
    @PostMapping("/test3")
    public void test3(HttpServletRequest request){
        String name = request.getParameter("name");
        System.out.println(name);
    }
}
