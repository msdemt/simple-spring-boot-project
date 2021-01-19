//package org.msdemt.simple.dubbo_demo_consumer;
//
//
//import org.msdemt.simple.dubbo_demo_interface.service.DemoService;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.dubbo.config.annotation.DubboReference;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.context.annotation.Bean;
//
///**
// * Dubbo Registry ZooKeeper Consumer Bootstrap
// */
//@Slf4j
//@EnableAutoConfiguration
//public class DubboDemoConsumerApplication {
//
//    @DubboReference(version = "${demo.service.version}")
//    private DemoService demoService;
//
//    public static void main(String[] args) {
//        SpringApplication.run(DubboDemoConsumerApplication.class).close();
//    }
//
//    @Bean
//    public ApplicationRunner runner() {
//        return args -> log.info(demoService.sayHello("mercyblitz"));
//    }
//}
