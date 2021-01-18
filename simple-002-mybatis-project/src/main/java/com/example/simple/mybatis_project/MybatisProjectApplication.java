package com.example.simple.mybatis_project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.simple.mybatis_project.dao.mapper") //扫描指定包下的mapper接口
public class MybatisProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisProjectApplication.class, args);
    }

}
