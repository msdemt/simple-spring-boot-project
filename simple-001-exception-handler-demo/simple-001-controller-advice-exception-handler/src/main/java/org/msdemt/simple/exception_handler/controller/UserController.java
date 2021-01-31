package org.msdemt.simple.exception_handler.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("user")
@RestController
public class UserController {

    @RequestMapping("hello")
    public String hello(){
        throw new NullPointerException("UserController hello has a NullPointerException");
    }
}
