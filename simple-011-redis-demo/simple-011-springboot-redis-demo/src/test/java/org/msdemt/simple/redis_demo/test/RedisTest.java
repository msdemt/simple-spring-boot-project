package org.msdemt.simple.redis_demo.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.msdemt.simple.redis_demo.test.pojo.User;
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

    @Test
    public void testRedisTemplateForSetObjectValue() throws JsonProcessingException {
        User user = new User("nike", 30, "beijing");
        redisTemplate.opsForValue().set("admin", user);
        //System.out.println((new Object(user)).toString());
        System.out.println(new ObjectMapper().writeValueAsString(user));
        System.out.println(redisTemplate.opsForValue().get("admin"));
        Assertions.assertEquals(new ObjectMapper().writeValueAsString(user), redisTemplate.opsForValue().get("admin"));
    }
}
