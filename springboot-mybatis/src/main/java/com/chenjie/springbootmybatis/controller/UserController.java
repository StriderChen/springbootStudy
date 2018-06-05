package com.chenjie.springbootmybatis.controller;

import com.chenjie.springbootmybatis.service.UserService;
import com.chenjie.springbootmybatis.vo.User;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author chenjie
 * @Date 2018/6/3 0:07
 * @Description:
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping(value = "/users")
    public Integer addUser(@RequestParam("userName") String userName,
                        @RequestParam("password") String password,
                        @RequestParam("phone") String phone) {
        User user = new User();
        user.setPassword(password);
        user.setUserName(userName);
        user.setPhone(phone);
        int i = userService.addUser(user);
        return i;
    }

    @GetMapping(value = "/users/{pageNum}/{pageSize}")
    public PageInfo<User> findAllUsers(@PathVariable(value = "pageNum")Integer pageNum,
                                       @PathVariable("pageSize") Integer pageSize){

        PageInfo<User> allUsers = userService.findAllUsers(pageNum, pageSize);

        return allUsers;
    }


}
