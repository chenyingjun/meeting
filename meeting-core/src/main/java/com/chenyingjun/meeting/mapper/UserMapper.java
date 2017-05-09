package com.chenyingjun.meeting.mapper;

import com.chenyingjun.meeting.entity.User;
import com.chenyingjun.meeting.utils.MyMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 测试用户信息dao
 *
 * @author chenyingjun
 * @version 2017年05月05日
 * @since 1.0
 */
@Mapper
public interface UserMapper extends MyMapper<User> {
    User selectByPrimaryKey(long id);
}