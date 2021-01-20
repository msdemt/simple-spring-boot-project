package org.msdemt.simple.mybatis_use_interface_proxy_demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.msdemt.simple.mybatis_use_interface_proxy_demo.dao.mapper") //扫描指定包下的mapper接口
public class MybatisDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisDemoApplication.class, args);
    }

}
