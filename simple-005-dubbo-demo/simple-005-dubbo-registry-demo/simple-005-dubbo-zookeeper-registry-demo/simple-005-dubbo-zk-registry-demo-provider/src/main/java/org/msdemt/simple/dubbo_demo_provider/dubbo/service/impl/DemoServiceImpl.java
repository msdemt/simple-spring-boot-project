//package org.msdemt.simple.dubbo_demo_provider.dubbo.service.impl;
//
//import org.msdemt.simple.dubbo_demo_interface.service.DemoService;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.dubbo.config.annotation.DubboService;
//import org.springframework.beans.factory.annotation.Value;
//
//@Slf4j
//@DubboService(version = "${demo.service.version}")
//public class DemoServiceImpl implements DemoService {
//    /**
//     * The default value of ${dubbo.application.name} is ${spring.application.name}
//     */
//    @Value("${dubbo.application.name}")
//    private String serviceName;
//    @Override
//    public String sayHello(String name) {
//        return String.format("[%s] : Hello, %s", serviceName, name);
//    }
//}
