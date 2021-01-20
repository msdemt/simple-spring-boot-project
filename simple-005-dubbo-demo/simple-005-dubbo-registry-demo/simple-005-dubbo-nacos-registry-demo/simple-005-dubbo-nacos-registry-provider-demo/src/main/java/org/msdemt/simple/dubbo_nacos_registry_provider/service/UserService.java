package org.msdemt.simple.dubbo_nacos_registry_provider.service;

import org.apache.dubbo.config.annotation.DubboService;
import org.msdemt.simple.dubbo_registry_demo_api.service.UserDubboService;
import org.springframework.beans.factory.annotation.Value;

@DubboService(version = "${user.service.version}")
public class UserService implements UserDubboService {
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
