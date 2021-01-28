package org.msdemt.proguard_demo.service;

import org.msdemt.proguard_demo.dao.entity.User;

public interface UserService {

    /**
     * 根据id获取用户信息
     * @param id
     * @return
     */
    User getUserById(Integer id);
}
