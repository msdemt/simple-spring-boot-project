package org.msdemt.simple.exception_handler.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("test")
@RestController
public class UserController implements BaseController{

    @RequestMapping("run")
    public String RuntimeExceptionTest(){
        throw new RuntimeException("runtime exception");
    }

    @RequestMapping("null")
    public String NullPointerExceptionTest(){
        throw new NullPointerException("null pointer exception");
    }

}
