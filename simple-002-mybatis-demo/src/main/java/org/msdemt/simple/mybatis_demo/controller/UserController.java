package org.msdemt.simple.mybatis_demo.controller;


import org.msdemt.simple.mybatis_demo.dao.entity.User;
import org.msdemt.simple.mybatis_demo.service.IUserService;
import org.msdemt.simple.unified_exception_handler_demo.pojo.response.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    //@ResponseBody
    @GetMapping("/{id}")
    public R<User> getUserById(@PathVariable("id") Integer id){
        return new R<>(userService.findUserById(id));
    }

}
