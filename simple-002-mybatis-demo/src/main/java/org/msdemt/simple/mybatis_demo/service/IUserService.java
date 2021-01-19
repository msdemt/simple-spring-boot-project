package org.msdemt.simple.mybatis_demo.service;

import org.msdemt.simple.mybatis_demo.dao.entity.User;

public interface IUserService {

    User findUserById(Integer id);
}
