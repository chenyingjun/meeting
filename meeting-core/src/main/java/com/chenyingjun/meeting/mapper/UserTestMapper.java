package com.chenyingjun.meeting.mapper;

import com.chenyingjun.meeting.entity.UserTest;
import com.chenyingjun.meeting.utils.MyMapper;

import java.util.List;

/**
 * 测试用户信息dao
 *
 * @author chenyingjun
 * @version 2017年05月05日
 * @since 1.0
 */
public interface UserTestMapper extends MyMapper<UserTest> {

    /**
     * 模糊查询用户信息
     * @param user 用户信息
     * @return
     */
    List<UserTest> selectLike(UserTest user);


}