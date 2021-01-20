package org.msdemt.simple.mybatis_not_use_interface_proxy_demo.dao.mapper.impl;

import org.msdemt.simple.mybatis_not_use_interface_proxy_demo.dao.BaseDao;
import org.msdemt.simple.mybatis_not_use_interface_proxy_demo.dao.entity.User;
import org.msdemt.simple.mybatis_not_use_interface_proxy_demo.dao.mapper.UserMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserMapperImpl extends BaseDao implements UserMapper {

    @Override
    public User getUserById(Integer id) {
        return getSqlSessionTemplate().selectOne("getUserById", id);
    }
}
