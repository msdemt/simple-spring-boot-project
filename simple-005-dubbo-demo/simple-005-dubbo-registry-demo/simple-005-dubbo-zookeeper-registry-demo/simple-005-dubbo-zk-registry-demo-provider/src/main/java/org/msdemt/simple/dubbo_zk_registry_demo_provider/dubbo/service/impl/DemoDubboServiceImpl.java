package org.msdemt.simple.dubbo_zk_registry_demo_provider.dubbo.service.impl;


import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.msdemt.simple.dubbo_registry_demo_api.service.UserDubboService;
import org.springframework.beans.factory.annotation.Value;

@Slf4j
@DubboService(version = "${user.service.version}")
public class DemoDubboServiceImpl implements UserDubboService {
    /**
     * The default value of ${dubbo.application.name} is ${spring.application.name}
     */
    @Value("${dubbo.application.name}")
    private String serviceName;

    @Override
    public String sayHello(String name) {
        return String.format("[%s] : Hello, %s", serviceName, name);
    }

    @Override
    public String getAllUsers() {
        return "json";
    }
}
