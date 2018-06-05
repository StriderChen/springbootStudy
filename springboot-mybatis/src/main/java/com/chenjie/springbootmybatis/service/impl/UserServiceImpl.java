package com.chenjie.springbootmybatis.service.impl;

import com.chenjie.springbootmybatis.dao.UserDao;
import com.chenjie.springbootmybatis.service.UserService;
import com.chenjie.springbootmybatis.vo.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author chenjie
 * @Date 2018/6/3 0:16
 * @Description:
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public int deleteById(Integer userId) {
        return userDao.deleteById(userId);
    }

    @Override
    public User findUserById(Integer userId) {
        return userDao.findUserById(userId);
    }

    @Override
    public int updateUserById(User user) {
        return userDao.updateUserById(user);
    }

    @Override
    public List<User> findAllUsers() {
        return userDao.findAllUsers();
    }


    @Override
    public PageInfo<User> findAllUsers(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        List<User> userDomains = userDao.findAllUsers();
        PageInfo result = new PageInfo(userDomains);
        return result;
    }

}
