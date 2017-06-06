package com.chenyingjun.meeting.service;

import com.chenyingjun.meeting.entity.UserTest;
import com.chenyingjun.meeting.mapper.UserTestMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
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
    private UserTestMapper userTestMapper;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    String keys = "chenyingjun";

    public UserTest getUserTestByPrimaryKey(Integer id){
        UserTest user = new UserTest();
        user.setUsername("333bb");
        List<UserTest> userList = userTestMapper.select(user);
        for (UserTest user1 : userList) {
            System.out.println("---------------------------" + user1.getPassword() + "--" + user1.getUsername());
        }
        return userTestMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询用户列表
     * @param user 查询用户信息
     * @param pageNum 当前页码
     * @param pageSize 每页数量
     * @return
     */
    public List<UserTest> page(UserTest user, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return userTestMapper.select(user);
    }

    /**
     * 模糊查询用户信息
     * @param user 查询用户信息
     * @return
     */
    public List<UserTest> like(UserTest user) {
        return userTestMapper.selectLike(user);
    }

    /**
     * 保存redis信息
     * @param keys redisKeys
     * @param value redisValue
     */
    public void saveRedis(String keys, String value) {
        ValueOperations<String, Object> operations = redisTemplate.opsForValue();
        operations.set(keys, value);
        System.out.println("redis设置了key：" + keys + "---------------------------value:" + value);
    }

    /**
     * 根据keys获取redis信息
     * @param keys redisKeys
     * @return
     */
    public String getRedis(String keys) {
        ValueOperations<String, Object> operations = redisTemplate.opsForValue();
        String value = String.valueOf(operations.get(keys));
        System.out.println("redis获取了key：" + keys + "---------------------------value:" + value);
        return value;
    }

    /**
     * 根据keys删除redis信息
     * @param keys redisKeys
     */
    public void removeRedis(String keys) {
        ValueOperations<String, Object> operations = redisTemplate.opsForValue();
        operations.getOperations().delete(keys);
    }

}
