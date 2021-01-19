package org.msdemt.simple.dubbo_demo_provider.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {

    @RequestMapping("/")
    public String sayHello(){
        return "index.html";
    }


}
