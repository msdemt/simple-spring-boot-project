package org.msdemt.simple.redis_demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@RequestMapping("/user")
@RestController
public class UserController {

    @RequestMapping("/hello")
    public String hello(HttpServletResponse response) throws IOException {
        response.sendError(404);
        return "123";
    }
}
