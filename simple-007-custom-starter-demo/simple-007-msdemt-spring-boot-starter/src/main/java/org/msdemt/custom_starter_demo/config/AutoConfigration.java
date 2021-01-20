package org.msdemt.custom_starter_demo.config;

import org.msdemt.custom_starter_demo.GetHashCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(AutoConfigurationProperties.class)
@ConditionalOnClass(GetHashCode.class)
public class AutoConfigration {

    private AutoConfigurationProperties properties;

    @Autowired
    public void setProperties(AutoConfigurationProperties properties) {
        this.properties = properties;
    }

    @ConditionalOnMissingBean
    @Bean
    public GetHashCode getHashCode(){
        return new GetHashCode(properties.getTarget());
    }
}
