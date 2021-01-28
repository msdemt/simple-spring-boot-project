package org.msdemt.proguard_demo.controller;

import org.msdemt.proguard_demo.dao.entity.User;
import org.msdemt.proguard_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    @ResponseBody
    public String sayHello(){
        return "Hello";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public User getUserById(@PathVariable("id") Integer id){
        return userService.getUserById(id);
    }
}
