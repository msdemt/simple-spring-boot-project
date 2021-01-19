package org.msdemt.simple.spring_data_jpa_demo.test;

import org.junit.jupiter.api.Test;
import org.msdemt.simple.spring_data_jpa_demo.dao.entity.User;
import org.msdemt.simple.spring_data_jpa_demo.dao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest(classes = SpringDataJpaApplication.class)
@SpringBootTest
public class JpaTest {

    @Autowired
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
