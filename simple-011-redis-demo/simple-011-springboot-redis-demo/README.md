# spring boot 项目集成 redis

由[springboot官方参考文档](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-redis)可知

Redis is a cache, message broker, and richly-featured key-value store. Spring Boot offers basic auto-configuration for the Lettuce and Jedis client libraries and the abstractions on top of them provided by Spring Data Redis.  
redis是一个缓存、消息代理、也是功能丰富的键值存储仓库。spring boot 为 Lettuce 和 Jedis 客户端库提供了基本的自动配置，并在 Lettuce 和 Jedis 客户端库之上由 spring data redis 提供了抽象。

There is a spring-boot-starter-data-redis “Starter” for collecting the dependencies in a convenient way. By default, it uses Lettuce. That starter handles both traditional and reactive applications.



Lettuce 和 Jedis 的都是连接Redis Server的客户端程序。Jedis在实现上是直连redis server，多线程环境下非线程安全（即多个线程对一个连接实例操作，是线程不安全的），除非使用连接池，为每个Jedis实例增加物理连接。Lettuce基于Netty的连接实例（StatefulRedisConnection），可以在多个线程间并发访问，且线程安全，满足多线程环境下的并发访问（即多个线程公用一个连接实例，线程安全），同时它是可伸缩的设计，一个连接实例不够的情况也可以按需增加连接实例。