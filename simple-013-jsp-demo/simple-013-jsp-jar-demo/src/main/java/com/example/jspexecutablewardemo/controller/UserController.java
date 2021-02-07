package com.example.jspexecutablewardemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequestMapping("/user")
@Controller
public class UserController {

    @RequestMapping("/register")
    public String register(){
        log.info("用户注册");

        return "UserRegistration";
    }

    @RequestMapping("/register/result")
    public String registerResult(String name, Model model){
        log.info("注册用户名：" + name);

        model.addAttribute("result", "用户：" + name + "注册成功");
        return "UserRegistrationResult";
    }

}
