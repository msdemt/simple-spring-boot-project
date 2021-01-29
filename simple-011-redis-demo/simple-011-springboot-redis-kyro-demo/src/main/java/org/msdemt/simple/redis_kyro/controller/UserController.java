package org.msdemt.simple.redis_kyro.controller;

import lombok.extern.slf4j.Slf4j;
import org.msdemt.simple.redis_kyro.pojo.Return;
import org.msdemt.simple.redis_kyro.pojo.User;
import org.msdemt.simple.redis_kyro.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/")
@RestController
public class UserController {

    private RedisUtil redisUtil;

    @Autowired
    public UserController(RedisUtil redisUtil) {
        this.redisUtil = redisUtil;
    }

    private static final String PREFIX = "user_";

    /**
     * key的拼装逻辑
     *
     * @param id
     * @return
     */
    private static String key(int id) {
        return PREFIX + id;
    }

    /**
     * 返回指定id的记录
     *
     * @param id
     */
    @GetMapping(value = "/get/{id}")
    public User get(@PathVariable("id") final int id) {
        User user = null;

        try {
            user = redisUtil.getObject(key(id));
        } catch (Exception e) {
            log.error("get from redis error, ", e);
        }

        return user;
    }

    /**
     * 删除指定id的记录
     *
     * @param id
     */
    @GetMapping(value = "/del/{id}")
    public String del(@PathVariable("id") final int id) {
        long removedKeysNum = 0;
        try {
            removedKeysNum = redisUtil.del(key(id));
        } catch (Exception e) {
            log.error("del from redis error, ", e);
        }

        return removedKeysNum > 0 ? ("del success[" + id + "]") : ("can not get user by id [" + id + "]");
    }

    /**
     * 向redis增加一条记录
     */
    @GetMapping(value = "/add/{id}/{name}/{age}")
    public Return add(@PathVariable("id") int id, @PathVariable("name") String name, @PathVariable("age") int age) {

        //Return<User> ret = new Return<User>();
        Return ret = new Return();
        User user = new User(id, name, age, null);

        try {
            redisUtil.set(key(id), user);
            ret.setT(user);
        } catch (Exception e) {
            ret.setT(null);
            log.error("save redis error, ", e);
        }

        return ret;
    }
}
