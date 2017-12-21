package com.chenyingjun.meeting.service;

import com.chenyingjun.meeting.constant.CommonConsts;
import com.chenyingjun.meeting.entity.User;
import com.chenyingjun.meeting.example.UserExample;
import com.chenyingjun.meeting.mapper.UserMapper;
import com.chenyingjun.meeting.utils.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    String keys = "chenyingjun";

    public User getUserByPrimaryKey(String id){
        return userMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询用户列表
     * @param user 查询用户信息
     * @param pageNum 当前页码
     * @param pageSize 每页数量
     * @return 用户page
     */
    public PageInfo<User> page(User user, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> list = list(user);
        return new PageInfo<> (list);
    }

    /**
     * 查询用户信息
     * @param user 查询条件
     * @return 用户信息列表
     */
    public List<User> list(User user) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        String name = user.getName();
        String account = user.getAccount();
        if (StringUtils.isNotEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        if (StringUtils.isNotEmpty(account)) {
            criteria.andAccountLike("%" + account + "%");
        }
        criteria.andStatusEqualTo(CommonConsts.DEL_FLAG_NORMAL);
        return userMapper.selectByExample(example);
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
