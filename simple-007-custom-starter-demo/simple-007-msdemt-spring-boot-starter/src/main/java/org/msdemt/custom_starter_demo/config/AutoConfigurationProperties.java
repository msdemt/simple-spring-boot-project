package org.msdemt.custom_starter_demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("msdemt.str")
public class AutoConfigurationProperties {

    private String target;

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}
