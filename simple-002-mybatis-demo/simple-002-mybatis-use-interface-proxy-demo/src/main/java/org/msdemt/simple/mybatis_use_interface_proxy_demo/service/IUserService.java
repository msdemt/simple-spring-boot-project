package org.msdemt.simple.mybatis_use_interface_proxy_demo.service;

import org.msdemt.simple.mybatis_use_interface_proxy_demo.dao.entity.User;

public interface IUserService {

    User findUserById(Integer id);
}
