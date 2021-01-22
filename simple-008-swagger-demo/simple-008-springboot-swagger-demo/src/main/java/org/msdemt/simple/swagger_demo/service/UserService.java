package org.msdemt.simple.swagger_demo.service;

import org.msdemt.simple.swagger_demo.dao.entity.User;

public interface UserService {

    User getUserById(Integer id);
}
