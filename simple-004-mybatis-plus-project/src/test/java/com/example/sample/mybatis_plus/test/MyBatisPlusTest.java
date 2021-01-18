package com.example.simple.mybatis_plus.test;

import com.example.simple.mybatis_plus.dao.entity.User;
import com.example.simple.mybatis_plus.dao.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class MyBatisPlusTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void testUserMapper() {
        List<User> userList = userMapper.selectList(null);
        if (userList != null && userList.size() > 0) {
            //for (User user : userList) {
            //    System.out.println("-->id:" + user.getId() + ", name:" + user.getName() + ", age:" + user.getAge() + ", address:" + user.getAddress());
            //}
            userList.forEach(System.out::println);
        }
    }
}
