package org.msdemt.proguard_demo.service.impl;

import org.msdemt.proguard_demo.dao.entity.Student;
import org.msdemt.proguard_demo.dao.entity.User;
import org.msdemt.proguard_demo.dao.repository.UserRepository;
import org.msdemt.proguard_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("userService")
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private final Student student;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, Student student) {
        this.userRepository = userRepository;
        this.student = student;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }




    @Override
    public User getUserById(Integer id) {
        User user = null;

        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()){
            user = userOptional.get();
        }
        return user;
    }
}
