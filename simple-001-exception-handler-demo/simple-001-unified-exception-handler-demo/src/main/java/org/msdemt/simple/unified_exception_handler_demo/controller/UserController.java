package org.msdemt.simple.unified_exception_handler_demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }
}
