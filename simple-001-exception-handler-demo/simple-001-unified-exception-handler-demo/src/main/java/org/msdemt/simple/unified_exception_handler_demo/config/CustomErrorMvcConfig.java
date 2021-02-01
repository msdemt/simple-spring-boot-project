package org.msdemt.simple.unified_exception_handler_demo.config;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.condition.SearchStrategy;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.Servlet;
import java.util.stream.Collectors;

@Configuration(proxyBeanMethods = false)
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
@ConditionalOnClass({Servlet.class, DispatcherServlet.class})
// Load before the main WebMvcAutoConfiguration so that the error View is available
@AutoConfigureBefore({WebMvcAutoConfiguration.class, ErrorMvcAutoConfiguration.class})
@EnableConfigurationProperties({ServerProperties.class, WebMvcProperties.class})
public class CustomErrorMvcConfig {

    private final ServerProperties serverProperties;

    private CustomErrorAttributes customErrorAttributes;

    @Autowired
    public CustomErrorMvcConfig(ServerProperties serverProperties, CustomErrorAttributes customErrorAttributes) {
        this.serverProperties = serverProperties;
        this.customErrorAttributes = customErrorAttributes;
    }

    @Bean
    @ConditionalOnMissingBean(value = ErrorController.class, search = SearchStrategy.ALL)
    public BasicErrorController basicErrorController(ErrorAttributes errorAttributes,
                                                     ObjectProvider<ErrorViewResolver> errorViewResolvers) {
        return new CustomErrorController(customErrorAttributes, this.serverProperties.getError(),
                errorViewResolvers.orderedStream().collect(Collectors.toList()));
    }
}
