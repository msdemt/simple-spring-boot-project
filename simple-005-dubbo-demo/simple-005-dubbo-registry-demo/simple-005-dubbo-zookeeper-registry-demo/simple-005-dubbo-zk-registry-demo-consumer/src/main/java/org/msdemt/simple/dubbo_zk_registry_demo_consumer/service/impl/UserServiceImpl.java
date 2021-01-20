package org.msdemt.simple.dubbo_zk_registry_demo_consumer.service.impl;

import org.apache.dubbo.config.annotation.DubboReference;
import org.msdemt.simple.dubbo_registry_demo_api.service.UserDubboService;
import org.msdemt.simple.dubbo_zk_registry_demo_consumer.service.IUserService;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @DubboReference(version = "${user.service.version}", check = false)
    private UserDubboService userDubboService;


    @Override
    public String getAllUsers() {
        return userDubboService.getAllUsers();
    }
}
