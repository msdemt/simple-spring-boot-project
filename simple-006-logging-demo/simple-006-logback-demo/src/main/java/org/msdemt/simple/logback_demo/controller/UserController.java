package org.msdemt.simple.logback_demo.controller;

import org.msdemt.simple.logback_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class UserController {

    @Autowired
    @Qualifier("userServiceImpl")
    UserService userService;

    @RequestMapping("/")
    public String sayHello() {
        return userService.sayHello();
    }
}
