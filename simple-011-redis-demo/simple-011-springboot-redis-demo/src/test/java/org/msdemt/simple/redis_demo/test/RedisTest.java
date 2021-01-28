package org.msdemt.simple.redis_demo.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.msdemt.simple.redis_demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testRedisTemplateForSetStringValue(){

        redisTemplate.opsForValue().set("hello", "world");
        stringRedisTemplate.opsForValue().set("key", "value");
        Assertions.assertEquals("world", redisTemplate.opsForValue().get("hello"));
        Assertions.assertEquals("value", stringRedisTemplate.opsForValue().get("key"));
    }

    /**
     * 使用redisTemplate存储对象
     * 1. 使用默认的解析器 JdkSerializationRedisSerializer，
     *     测试用例成功，输出结果:
     *       User(name=nike, age=30, address=beijing)
     *       {"name":"nike","age":30,"address":"beijing"}
     *       User(name=nike, age=30, address=beijing)
     *
     * 2. 使用 Jackson2JsonRedisSerializer 解析器，解析器参数置为Object，
     *  template.setDefaultSerializer(new Jackson2JsonRedisSerializer<>(Object.class));
     *
     *      输出结果：
     *
     *      User(name=nike, age=30, address=beijing)
     *      {"name":"nike","age":30,"address":"beijing"}
     *      java.lang.ClassCastException: java.util.LinkedHashMap cannot be cast to org.msdemt.simple.redis_demo.pojo.User
     *
     *      此时(User)redisTemplate.opsForValue().get("admin")发生类型强转错误，因为此时redis中没有存储类型信息
     *      redisTemplate.opsForValue().get("admin") 打印出的结果是 {name=nike, age=30, address=beijing}
     *
     *      并且assert判断会失败，信息如下（期望是一个user类，但实际上redis中存储的是json字符串）
     *      org.opentest4j.AssertionFailedError:
     *      Expected :User(name=nike, age=30, address=beijing)
     *      Actual   :{name=nike, age=30, address=beijing}
     *
     *  使用 Jackson2JsonRedisSerializer 解析器，解析器参数置为User，
     *  template.setDefaultSerializer(new Jackson2JsonRedisSerializer<>(User.class));
     *
     *      测试用例执行成功，输出结果：
     *      User(name=nike, age=30, address=beijing)
     *      {"name":"nike","age":30,"address":"beijing"}
     *      User(name=nike, age=30, address=beijing)
     *
     * 3. 使用 GenericJackson2JsonRedisSerializer 解析器，该解析器会自动保存对象类型，不用传入参数，
     *  template.setDefaultSerializer(new GenericJackson2JsonRedisSerializer());
     *
     *      测试用例执行成功，输出结果：
     *      User(name=nike, age=30, address=beijing)
     *      {"name":"nike","age":30,"address":"beijing"}
     *      User(name=nike, age=30, address=beijing)
     *
     * 总结，一般情况下，使用 GenericJackson2JsonRedisSerializer 即可。
     * @throws JsonProcessingException
     */
    @Test
    public void testRedisTemplateForSetObjectValue() throws JsonProcessingException {
        User user = new User("nike", 30, "beijing");
        redisTemplate.opsForValue().set("admin", user);
        System.out.println(user.toString());
        System.out.println(new ObjectMapper().writeValueAsString(user));
        System.out.println((User)redisTemplate.opsForValue().get("admin"));
        Assertions.assertEquals(user, redisTemplate.opsForValue().get("admin"));
    }
}
