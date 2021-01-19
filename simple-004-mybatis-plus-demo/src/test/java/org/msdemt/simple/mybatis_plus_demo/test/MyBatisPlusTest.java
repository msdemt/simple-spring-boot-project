package org.msdemt.simple.mybatis_plus_demo.test;

import org.junit.jupiter.api.Test;
import org.msdemt.simple.mybatis_plus_demo.dao.entity.User;
import org.msdemt.simple.mybatis_plus_demo.dao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MyBatisPlusTest {

    @Autowired
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
