package org.msdemt.simple.redis_kyro.controller;

import lombok.extern.slf4j.Slf4j;
import org.msdemt.simple.redis_kyro.enums.UserRespEnum;
import org.msdemt.simple.redis_kyro.pojo.User;
import org.msdemt.simple.redis_kyro.service.UserService;
import org.msdemt.simple.unified_exception_handler_demo.pojo.response.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/")
@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/add/{id}/{name}/{age}")
    public R add(@PathVariable("id") final Integer id, @PathVariable("name") final String name,
                 @PathVariable("age") final Integer age) {
        Integer i = null;
        int a = 300/i;
        return R.ok();

        //User user = new User(id, name, age, null);
        //userService.addUser(user);
        //return new R(user);
    }

    @GetMapping(value = "/get/{id}")
    public R get(@PathVariable("id") final Integer id) {
        User user = userService.getUser(id);
        return R.ok(user);
    }

    @GetMapping(value = "/del/{id}")
    public R del(@PathVariable("id") final Integer id) {
        User user = userService.delUser(id);
        UserRespEnum.USER_NOT_EXIST.assertNotNull(user);
        return R.ok(user);
    }

    @PostMapping(value = "/add")
    public R add(@Validated User user){
        return R.ok(userService.addUser(user));
    }

}
