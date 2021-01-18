package com.example.simple.dubbo_demo_provider.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class DemoController {

    @RequestMapping("/")
    public String sayHello(){
        return "index.html";
    }


}
