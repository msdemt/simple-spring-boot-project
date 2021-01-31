package org.msdemt.simple.redis_kyro.config;

import org.msdemt.simple.redis_kyro.serializer.KryoRedisSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);

        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new KryoRedisSerializer<>());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(new KryoRedisSerializer<>());

        return template;
    }
}
