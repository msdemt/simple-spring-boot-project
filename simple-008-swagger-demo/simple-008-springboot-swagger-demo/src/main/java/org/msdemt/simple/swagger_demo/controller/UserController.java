package org.msdemt.simple.swagger_demo.controller;

import io.swagger.annotations.*;
import org.msdemt.simple.swagger_demo.dao.entity.User;
import org.msdemt.simple.swagger_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "用户管理")
@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation("根据id查询用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "查询成功"),
            @ApiResponse(code = 500, message = "服务端异常")
    })
    @GetMapping("/{id}")
    public User findUserById(@PathVariable("id") Integer id) {
        return userService.getUserById(id);
    }
}
