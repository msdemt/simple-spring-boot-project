package com.example.simple.spring_data_jpa.test;

import com.example.simple.spring_data_jpa.dao.entity.User;
import com.example.simple.spring_data_jpa.dao.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class JpaTest {

    @Resource
    private UserRepository userRepository;

    @Test
    public void testSave(){
        User user = new User();
        user.setName("nike");
        user.setAge(28);
        user.setAddress("Shandong");

        userRepository.save(user);
    }
}
