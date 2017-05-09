package com.chenyingjun.meeting.service;

import com.chenyingjun.meeting.entity.User;
import com.chenyingjun.meeting.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 测试用户信息服务
 *
 * @author chenyingjun
 * @version 2017年05月05日
 * @since 1.0
 */
@Service
public class UserService {
//
//    @Autowired
//    private UserMapper userMapper;

    public User selectByPrimaryKey(long id){
        return null;
    }

}
