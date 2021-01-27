package org.msdemt.simple.logback_demo.service.impl;

import org.msdemt.simple.logback_demo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl2 implements UserService {
    @Override
    public String sayHello() {
        return "Hello2";
    }
}
