package org.msdemt.starter_test.controller;


import org.msdemt.custom_starter_demo.GetHashCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/")
public class DemoController {
    @Resource
    private GetHashCode getHashCode;

    @GetMapping("/gethash")
    public String getHash(){
        return getHashCode.getHashCode();
    }
}
