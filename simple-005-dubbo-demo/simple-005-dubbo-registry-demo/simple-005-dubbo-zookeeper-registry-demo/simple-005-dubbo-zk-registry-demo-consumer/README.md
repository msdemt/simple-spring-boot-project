

启动时出现红色警告
```log
log4j:WARN No appenders could be found for logger (org.apache.dubbo.common.logger.LoggerFactory).
log4j:WARN Please initialize the log4j system properly.
log4j:WARN See http://logging.apache.org/log4j/1.2/faq.html#noconfig for more info.
```
解决：原因是zookeeper里依赖了log4j

排除 log4j 依赖
```xml
<!-- Zookeeper dependencies -->
<dependency>
    <groupId>org.apache.dubbo</groupId>
    <artifactId>dubbo-dependencies-zookeeper</artifactId>
    <version>${dubbo.version}</version>
    <type>pom</type>
    <exclusions>
        <exclusion>
            <groupId>log4j</groupId>
            <artifactId>log4j</artifactId>
        </exclusion>
    </exclusions>
</dependency>
```


当dubbo服务提供者没有启动的时候，消费者启动失败

```log
2021-01-20 15:44:32.094 ERROR 6472 --- [           main] o.s.boot.SpringApplication               : Application run failed

org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'userController': Unsatisfied dependency expressed through method 'setUserService' parameter 0; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'userService': Injection of @DubboReference dependencies is failed; nested exception is java.lang.IllegalStateException: Failed to check the status of the service UserDubboService. No provider available for the service UserDubboService:1.0.0 from the url zookeeper://127.0.0.1:2181/org.apache.dubbo.registry.RegistryService?application=simple-dubbo-zk-registry-demo-consumer&dubbo=2.0.2&init=false&interface=UserDubboService&metadata-type=remote&methods=getAllUsers,sayHello&pid=6472&qos.enable=false&register.ip=172.19.32.1&release=2.7.8&revision=1.0.0&side=consumer&sticky=false&timestamp=1611128671721&version=1.0.0 to the consumer 172.19.32.1 use dubbo version 2.7.8
	at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor$AutowiredMethodElement.inject(AutowiredAnnotationBeanPostProcessor.java:722) ~[spring-beans-5.3.3.jar:5.3.3]
	at org.springframework.beans.factory.annotation.InjectionMetadata.inject(InjectionMetadata.java:119) ~[spring-beans-5.3.3.jar:5.3.3]
	at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor.postProcessProperties(AutowiredAnnotationBeanPostProcessor.java:399) ~[spring-beans-5.3.3.jar:5.3.3]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.populateBean(AbstractAutowireCapableBeanFactory.java:1415) ~[spring-beans-5.3.3.jar:5.3.3]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:608) ~[spring-beans-5.3.3.jar:5.3.3]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:531) ~[spring-beans-5.3.3.jar:5.3.3]
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:335) ~[spring-beans-5.3.3.jar:5.3.3]
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234) ~[spring-beans-5.3.3.jar:5.3.3]
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:333) ~[spring-beans-5.3.3.jar:5.3.3]
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:208) ~[spring-beans-5.3.3.jar:5.3.3]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:944) ~[spring-beans-5.3.3.jar:5.3.3]
	at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:923) ~[spring-context-5.3.3.jar:5.3.3]
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:588) ~[spring-context-5.3.3.jar:5.3.3]
	at org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext.refresh(ServletWebServerApplicationContext.java:144) ~[spring-boot-2.4.2.jar:2.4.2]
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:767) [spring-boot-2.4.2.jar:2.4.2]
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:759) [spring-boot-2.4.2.jar:2.4.2]
	at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:426) [spring-boot-2.4.2.jar:2.4.2]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:326) [spring-boot-2.4.2.jar:2.4.2]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1311) [spring-boot-2.4.2.jar:2.4.2]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1300) [spring-boot-2.4.2.jar:2.4.2]
	at org.msdemt.simple.dubbo_zk_registry_demo_consumer.ConsumerApplication.main(ConsumerApplication.java:13) [classes/:na]
Caused by: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'userService': Injection of @DubboReference dependencies is failed; nested exception is java.lang.IllegalStateException: Failed to check the status of the service UserDubboService. No provider available for the service UserDubboService:1.0.0 from the url zookeeper://127.0.0.1:2181/org.apache.dubbo.registry.RegistryService?application=simple-dubbo-zk-registry-demo-consumer&dubbo=2.0.2&init=false&interface=UserDubboService&metadata-type=remote&methods=getAllUsers,sayHello&pid=6472&qos.enable=false&register.ip=172.19.32.1&release=2.7.8&revision=1.0.0&side=consumer&sticky=false&timestamp=1611128671721&version=1.0.0 to the consumer 172.19.32.1 use dubbo version 2.7.8
	at com.alibaba.spring.beans.factory.annotation.AbstractAnnotationBeanPostProcessor.postProcessPropertyValues(AbstractAnnotationBeanPostProcessor.java:146) ~[spring-context-support-1.0.8.jar:na]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.populateBean(AbstractAutowireCapableBeanFactory.java:1420) ~[spring-beans-5.3.3.jar:5.3.3]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:608) ~[spring-beans-5.3.3.jar:5.3.3]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:531) ~[spring-beans-5.3.3.jar:5.3.3]
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:335) ~[spring-beans-5.3.3.jar:5.3.3]
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234) ~[spring-beans-5.3.3.jar:5.3.3]
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:333) ~[spring-beans-5.3.3.jar:5.3.3]
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:208) ~[spring-beans-5.3.3.jar:5.3.3]
	at org.springframework.beans.factory.config.DependencyDescriptor.resolveCandidate(DependencyDescriptor.java:276) ~[spring-beans-5.3.3.jar:5.3.3]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.doResolveDependency(DefaultListableBeanFactory.java:1380) ~[spring-beans-5.3.3.jar:5.3.3]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.resolveDependency(DefaultListableBeanFactory.java:1300) ~[spring-beans-5.3.3.jar:5.3.3]
	at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor$AutowiredMethodElement.inject(AutowiredAnnotationBeanPostProcessor.java:714) ~[spring-beans-5.3.3.jar:5.3.3]
	... 20 common frames omitted
Caused by: java.lang.IllegalStateException: Failed to check the status of the service UserDubboService. No provider available for the service UserDubboService:1.0.0 from the url zookeeper://127.0.0.1:2181/org.apache.dubbo.registry.RegistryService?application=simple-dubbo-zk-registry-demo-consumer&dubbo=2.0.2&init=false&interface=UserDubboService&metadata-type=remote&methods=getAllUsers,sayHello&pid=6472&qos.enable=false&register.ip=172.19.32.1&release=2.7.8&revision=1.0.0&side=consumer&sticky=false&timestamp=1611128671721&version=1.0.0 to the consumer 172.19.32.1 use dubbo version 2.7.8
	at org.apache.dubbo.config.ReferenceConfig.checkInvokerAvailable(ReferenceConfig.java:420) ~[dubbo-2.7.8.jar:2.7.8]
	at org.apache.dubbo.config.ReferenceConfig.init(ReferenceConfig.java:315) ~[dubbo-2.7.8.jar:2.7.8]
	at org.apache.dubbo.config.ReferenceConfig.get(ReferenceConfig.java:205) ~[dubbo-2.7.8.jar:2.7.8]
	at org.apache.dubbo.config.spring.beans.factory.annotation.ReferenceAnnotationBeanPostProcessor.doGetInjectedBean(ReferenceAnnotationBeanPostProcessor.java:144) ~[dubbo-2.7.8.jar:2.7.8]
	at com.alibaba.spring.beans.factory.annotation.AbstractAnnotationBeanPostProcessor.getInjectedObject(AbstractAnnotationBeanPostProcessor.java:359) ~[spring-context-support-1.0.8.jar:na]
	at com.alibaba.spring.beans.factory.annotation.AbstractAnnotationBeanPostProcessor$AnnotatedFieldElement.inject(AbstractAnnotationBeanPostProcessor.java:539) ~[spring-context-support-1.0.8.jar:na]
	at org.springframework.beans.factory.annotation.InjectionMetadata.inject(InjectionMetadata.java:119) ~[spring-beans-5.3.3.jar:5.3.3]
	at com.alibaba.spring.beans.factory.annotation.AbstractAnnotationBeanPostProcessor.postProcessPropertyValues(AbstractAnnotationBeanPostProcessor.java:142) ~[spring-context-support-1.0.8.jar:na]
	... 31 common frames omitted

2021-01-20 15:44:32.099  INFO 6472 --- [bboShutdownHook] o.apache.dubbo.config.DubboShutdownHook  :  [DUBBO] Run shutdown hook now., dubbo version: 2.7.8, current host: 172.19.32.1
2021-01-20 15:44:32.103  INFO 6472 --- [bboShutdownHook] o.a.d.r.support.AbstractRegistryFactory  :  [DUBBO] Close all registries [zookeeper://127.0.0.1:2181/org.apache.dubbo.registry.RegistryService?application=simple-dubbo-zk-registry-demo-consumer&dubbo=2.0.2&file=C:\\Users\\hekai/dubbo-cache/simple-dubbo-zk-registry-demo-consumer/dubbo.cache&interface=org.apache.dubbo.registry.RegistryService&pid=6472&qos.enable=false&release=2.7.8&timestamp=1611128671769], dubbo version: 2.7.8, current host: 172.19.32.1
2021-01-20 15:44:32.103  INFO 6472 --- [bboShutdownHook] o.a.d.r.zookeeper.ZookeeperRegistry      :  [DUBBO] Destroy registry:zookeeper://127.0.0.1:2181/org.apache.dubbo.registry.RegistryService?application=simple-dubbo-zk-registry-demo-consumer&dubbo=2.0.2&file=C:\\Users\\hekai/dubbo-cache/simple-dubbo-zk-registry-demo-consumer/dubbo.cache&interface=org.apache.dubbo.registry.RegistryService&pid=6472&qos.enable=false&release=2.7.8&timestamp=1611128671769, dubbo version: 2.7.8, current host: 172.19.32.1
2021-01-20 15:44:32.103  INFO 6472 --- [bboShutdownHook] o.a.d.r.zookeeper.ZookeeperRegistry      :  [DUBBO] Unsubscribe: consumer://172.19.32.1/UserDubboService?application=simple-dubbo-zk-registry-demo-consumer&category=providers,configurators,routers&dubbo=2.0.2&init=false&interface=UserDubboService&metadata-type=remote&methods=getAllUsers,sayHello&pid=6472&qos.enable=false&release=2.7.8&revision=1.0.0&side=consumer&sticky=false&timestamp=1611128671721&version=1.0.0, dubbo version: 2.7.8, current host: 172.19.32.1
2021-01-20 15:44:32.104  INFO 6472 --- [bboShutdownHook] o.a.d.r.zookeeper.ZookeeperRegistry      :  [DUBBO] Destroy unsubscribe url consumer://172.19.32.1/UserDubboService?application=simple-dubbo-zk-registry-demo-consumer&category=providers,configurators,routers&dubbo=2.0.2&init=false&interface=UserDubboService&metadata-type=remote&methods=getAllUsers,sayHello&pid=6472&qos.enable=false&release=2.7.8&revision=1.0.0&side=consumer&sticky=false&timestamp=1611128671721&version=1.0.0, dubbo version: 2.7.8, current host: 172.19.32.1
2021-01-20 15:44:32.106  INFO 6472 --- [tor-Framework-0] o.a.c.f.imps.CuratorFrameworkImpl        : backgroundOperationsLoop exiting
2021-01-20 15:44:32.119  INFO 6472 --- [bboShutdownHook] org.apache.zookeeper.ZooKeeper           : Session: 0x10000c3e75b0005 closed
2021-01-20 15:44:32.120  INFO 6472 --- [ain-EventThread] org.apache.zookeeper.ClientCnxn          : EventThread shut down for session: 0x10000c3e75b0005
2021-01-20 15:44:32.124  INFO 6472 --- [bboShutdownHook] org.apache.dubbo.qos.server.Server       :  [DUBBO] qos-server stopped., dubbo version: 2.7.8, current host: 172.19.32.1
2021-01-20 15:44:32.128  INFO 6472 --- [bboShutdownHook] o.a.d.c.e.listener.LoggingEventListener  :  [DUBBO] Dubbo Service has been destroyed., dubbo version: 2.7.8, current host: 172.19.32.1
Disconnected from the target VM, address: '127.0.0.1:4956', transport: 'socket'
```

解决：在@DubboReference注解上添加check=false

```java
@DubboReference(version = "${user.service.version}", check = false)
private UserDubboService userDubboService;
```
