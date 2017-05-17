package com.chenyingjun.meeting.service;

import com.chenyingjun.meeting.entity.User;
import com.chenyingjun.meeting.mapper.UserMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 测试用户信息服务
 *
 * @author chenyingjun
 * @version 2017年05月05日
 * @since 1.0
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User selectByPrimaryKey(Integer id){
        User user = new User();
        user.setUsername("333bb");
        List<User> userList = userMapper.select(user);
        for (User user1 : userList) {
            System.out.println("---------------------------" + user1.getPassword() + "--" + user1.getUsername());
        }
        return userMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询用户列表
     * @param user 查询用户信息
     * @param pageNum 当前页码
     * @param pageSize 每页数量
     * @return
     */
    public List<User> selectPage(User user, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return userMapper.select(user);
    }

    /**
     * 模糊查询用户信息
     * @param user 查询用户信息
     * @return
     */
    public List<User> selectLike(User user) {
        return userMapper.selectLike(user);
    }

}
