package org.msdemt.simple.redis_kyro.service;

import org.msdemt.simple.redis_kyro.pojo.User;

public interface UserService {

    /**
     * 添加用户
     * @param user
     */
    User addUser(User user);

    /**
     * 查询用户
     * @param id
     * @return
     */
    User getUser(Integer id);

    /**
     * 删除用户
     * @param id
     * @return
     */
    User delUser(Integer id);
}
