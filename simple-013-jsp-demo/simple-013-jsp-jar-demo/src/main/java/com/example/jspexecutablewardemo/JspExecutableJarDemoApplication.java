package com.example.jspexecutablewardemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class JspExecutableJarDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JspExecutableJarDemoApplication.class, args);
    }

}
