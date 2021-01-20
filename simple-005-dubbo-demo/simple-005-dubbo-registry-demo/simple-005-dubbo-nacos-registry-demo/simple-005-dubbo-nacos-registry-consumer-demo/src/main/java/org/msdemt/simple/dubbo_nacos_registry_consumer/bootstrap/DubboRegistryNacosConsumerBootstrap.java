package org.msdemt.simple.dubbo_nacos_registry_consumer.bootstrap;

import org.apache.dubbo.config.annotation.DubboReference;
import org.msdemt.simple.dubbo_registry_demo_api.service.UserDubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * Dubbo Registry Nacos Consumer Bootstrap
 */
@EnableAutoConfiguration
public class DubboRegistryNacosConsumerBootstrap {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @DubboReference(version = "${user.service.version}",check = false)
    private UserDubboService userDubboService;

    public static void main(String[] args) {
        SpringApplication.run(DubboRegistryNacosConsumerBootstrap.class).close();
    }

    @Bean
    public ApplicationRunner runner() {
        return args -> logger.info(userDubboService.sayHello("mercyblitz"));
    }
}
