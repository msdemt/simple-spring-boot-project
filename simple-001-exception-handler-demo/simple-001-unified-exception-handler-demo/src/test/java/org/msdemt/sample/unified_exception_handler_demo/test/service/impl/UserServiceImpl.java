package org.msdemt.sample.unified_exception_handler_demo.test.service.impl;

import org.msdemt.sample.unified_exception_handler_demo.test.pojo.User;
import org.msdemt.sample.unified_exception_handler_demo.test.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Override
    public User findUserById(Integer id) {
        // 校验非空
//        ResponseEnum.LICENCE_NOT_FOUND.assertNotNull(null);
        return new User();
    }
}
