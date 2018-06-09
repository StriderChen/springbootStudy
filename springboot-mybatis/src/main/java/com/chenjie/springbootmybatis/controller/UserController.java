package com.chenjie.springbootmybatis.controller;

import com.chenjie.springbootmybatis.service.UserService;
import com.chenjie.springbootmybatis.vo.User;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author chenjie
 * @Date 2018/6/3 0:07
 * @Description:
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 增加一个用户
     *
     * @param userName
     * @param password
     * @param phone
     * @return
     */
    @PostMapping(value = "/users")
    public Integer addUser(@RequestParam("userName") String userName,
                           @RequestParam("password") String password,
                           @RequestParam("phone") String phone) {
        User user = new User();
        user.setPassword(password);
        user.setUserName(userName);
        user.setPhone(phone);
        Integer i = userService.addUser(user);
        return i;
    }

    /**
     * 查询所有的用户
     *
     * @return
     */
    @GetMapping(value = "/users")
    public List<User> findAllUsers() {
        List<User> allUsers = userService.findAllUsers();
        return allUsers;
    }


    /**
     * 分页查询用户
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping(value = "/users/{pageNum}/{pageSize}")
    public PageInfo<User> findAllUsers(@PathVariable(value = "pageNum") Integer pageNum,
                                       @PathVariable("pageSize") Integer pageSize) {

        PageInfo<User> allUsers = userService.findAllUsers(pageNum, pageSize);
        return allUsers;
    }

    /**
     * 根据id查询一个用户
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/users/{id}")
    public User findUserById(@PathVariable("id") Integer id) {
        User user = userService.findUserById(id);
        return user;
    }


    /**
     * 根据ID删除一个用户
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/users/{id}")
    public Integer deleteUserById(@PathVariable(value = "id") Integer id) {
        Integer deletedId = userService.deleteById(id);
        return deletedId;
    }

    @PutMapping(value = "/users/{id}")
    public Integer updateUserById(@PathVariable(value = "id") Integer id,
                                  @RequestParam(value = "userName") String userName,
                                  @RequestParam(value = "password") String password,
                                  @RequestParam(value = "phone") String phone) {
        User user = new User();
        user.setPhone(phone);
        user.setUserName(userName);
        user.setPassword(password);
        user.setUserId(id);
        Integer userId = userService.updateUserById(user);
        return userId;
    }

}
