package com.example.simple.mybatis_project.service;

import com.example.simple.mybatis_project.dao.entity.User;

public interface IUserService {

    User findUserById(Integer id);
}
