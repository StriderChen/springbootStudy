package com.chenjie.springbootmybatis.service;

import com.chenjie.springbootmybatis.vo.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Author chenjie
 * @Date 2018/6/3 0:06
 * @Description:
 */
public interface UserService {
    /**
     * 增加一个用户
     * @param user
     * @return
     */
    Integer addUser(User user);

    /**
     * 增加一个用户
     * @param user
     * @return
     */
    Integer insertSelective(User user);

    /**
     * 删除用户
     * @param userId
     * @return
     */
    Integer deleteById(Integer userId);

    /**
     * 根据ID查找用户
     * @param userId
     * @return
     */
    User findUserById(Integer userId);

    /**
     * 根据ID更新用户
     * @param user
     * @return
     */
    Integer updateUserById(User user);

    /**
     * 查找所有用户
     * @return
     */
    List<User> findAllUsers();

    /**
     * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
     * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
     * pageNum 开始页数
     * pageSize 每页显示的数据条数
     * */
    PageInfo<User> findAllUsers(Integer pageNum, Integer pageSize);
}
