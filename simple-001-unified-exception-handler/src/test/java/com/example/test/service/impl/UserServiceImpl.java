package com.example.test.service.impl;

import com.example.test.enums.ResponseEnum;
import com.example.test.pojo.User;
import com.example.test.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Override
    public User findUserById(Integer id) {
        // 校验非空
        ResponseEnum.LICENCE_NOT_FOUND.assertNotNull(null);
        return null;
    }
}
