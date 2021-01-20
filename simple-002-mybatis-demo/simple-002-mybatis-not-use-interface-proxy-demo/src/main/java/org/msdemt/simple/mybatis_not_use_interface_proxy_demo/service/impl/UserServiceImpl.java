package org.msdemt.simple.mybatis_not_use_interface_proxy_demo.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.msdemt.simple.mybatis_not_use_interface_proxy_demo.dao.entity.User;
import org.msdemt.simple.mybatis_not_use_interface_proxy_demo.dao.mapper.UserMapper;
import org.msdemt.simple.mybatis_not_use_interface_proxy_demo.enums.ResponseEnum;
import org.msdemt.simple.mybatis_not_use_interface_proxy_demo.service.IUserService;
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
