package org.msdemt.simple.mybatis_use_interface_proxy_demo.dao.mapper;

import org.msdemt.simple.mybatis_use_interface_proxy_demo.dao.entity.User;

public interface UserMapper {

    User getUserById(Integer id);
}
