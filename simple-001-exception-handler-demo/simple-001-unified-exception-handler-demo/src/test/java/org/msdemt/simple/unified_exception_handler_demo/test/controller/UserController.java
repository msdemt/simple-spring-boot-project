package org.msdemt.simple.unified_exception_handler_demo.test.controller;

import org.msdemt.simple.unified_exception_handler_demo.test.pojo.User;
import org.msdemt.simple.unified_exception_handler_demo.test.service.IUserService;
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

    @GetMapping("/{id}")
    public R<User> getUserById(@PathVariable("id") Integer id){
        return R.ok(userService.findUserById(id));
    }

    @GetMapping("/null")
    public R<User> testServerException(){
        throw new NullPointerException("空指针异常");
    }

    @RequestMapping("/hello")
    public String hello(HttpServletResponse response) throws IOException {
        response.sendError(404);
        return "123";
    }

}
