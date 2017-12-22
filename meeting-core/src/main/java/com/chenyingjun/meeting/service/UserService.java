package com.chenyingjun.meeting.service;

import com.chenyingjun.meeting.constant.CommonConsts;
import com.chenyingjun.meeting.entity.User;
import com.chenyingjun.meeting.example.UserExample;
import com.chenyingjun.meeting.mapper.UserMapper;
import com.chenyingjun.meeting.utils.StringUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

/**
 * 测试用户信息服务
 *
 * @author chenyingjun
 * @version 2017年05月05日
 * @since 1.0
 */
@Service
public class UserService extends BaseService<User>{
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    String keys = "chenyingjun";

    public User getUserByPrimaryKey(String id){
        return userMapper.selectByPrimaryKey(id);
    }

    public PageInfo<User> page(User user, int pageNum, int pageSize) {
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
        criteria.andDelFlagEqualTo(CommonConsts.DEL_FLAG_NORMAL);
        return this.basePageByExample(example, pageNum, pageSize);
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
