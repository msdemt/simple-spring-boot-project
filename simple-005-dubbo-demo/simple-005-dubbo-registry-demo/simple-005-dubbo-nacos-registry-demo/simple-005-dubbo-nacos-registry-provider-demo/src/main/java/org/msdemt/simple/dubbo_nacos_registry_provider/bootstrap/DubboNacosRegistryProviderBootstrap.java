package org.msdemt.simple.dubbo_nacos_registry_provider.bootstrap;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;

@EnableAutoConfiguration
public class DubboNacosRegistryProviderBootstrap {

    public static void main(String[] args) {
        new SpringApplicationBuilder(DubboNacosRegistryProviderBootstrap.class).run(args);
    }
}
