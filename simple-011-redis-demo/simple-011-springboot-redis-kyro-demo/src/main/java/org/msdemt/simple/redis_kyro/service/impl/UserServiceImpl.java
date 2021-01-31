package org.msdemt.simple.redis_kyro.service.impl;

import org.msdemt.simple.redis_kyro.pojo.User;
import org.msdemt.simple.redis_kyro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    private static final String PREFIX = "user_";

    private RedisTemplate redisTemplate;

    @Autowired
    public UserServiceImpl(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public User addUser(User user) {
        redisTemplate.opsForValue().set(key(user.getId()), user);
        return user;
    }

    @Override
    public User getUser(Integer id) {
        return (User) redisTemplate.opsForValue().get(key(id));
    }

    @Override
    public User delUser(Integer id) {
        User user = (User) redisTemplate.opsForValue().get(key(id));
        Boolean isSuccess =  redisTemplate.delete(key(id));
        if(isSuccess) {
            return user;
        }
        return null;
    }

    /**
     * 组装key
     * @param id
     * @return
     */
    private static String key(Integer id) {
        return PREFIX + id;
    }
}
