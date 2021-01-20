package org.msdemt.simple.dubbo_zk_registry_demo_consumer.controller;

import org.msdemt.simple.dubbo_zk_registry_demo_consumer.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    private IUserService userService;

    //使用set方法注入，避免Field injection is not recommended 警告
    @Autowired
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String hello (){
        return "index.html";
    }

    @GetMapping("/users")
    @ResponseBody
    public String getAllUsers(){
        return userService.getAllUsers();
    }

}
