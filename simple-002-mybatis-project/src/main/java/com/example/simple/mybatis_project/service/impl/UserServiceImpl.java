package com.example.simple.mybatis_project.service.impl;

import com.example.simple.mybatis_project.dao.entity.User;
import com.example.simple.mybatis_project.dao.mapper.UserMapper;
import com.example.simple.mybatis_project.enums.ResponseEnum;
import com.example.simple.mybatis_project.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements IUserService {

    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User findUserById(Integer id) {
        //校验非空
        ResponseEnum.REQUEST_IS_NULL.assertNotNull(id);
        User user = userMapper.getUserById(id);
        //校验用户是否存在
        ResponseEnum.NOT_EXIST_USER.assertNotNull(user);
        return user;
    }
}
