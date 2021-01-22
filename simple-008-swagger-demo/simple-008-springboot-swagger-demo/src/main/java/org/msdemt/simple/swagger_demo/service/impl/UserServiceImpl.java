package org.msdemt.simple.swagger_demo.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.msdemt.simple.swagger_demo.dao.entity.User;
import org.msdemt.simple.swagger_demo.dao.repository.UserRepository;
import org.msdemt.simple.swagger_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(Integer id) {
        log.info("根据id:" + id + "查询用户信息");
        Optional<User> optionalUser = userRepository.findById(id);
        User user;
        if (optionalUser.isPresent()) {
            user = optionalUser.get();
        } else {
            user = null;
        }
        //
        //optionalUser.ifPresent( user1 -> return user1;);
        return user;
    }
}
