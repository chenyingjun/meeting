package com.chenyingjun.meeting.service;

import com.chenyingjun.meeting.mapper.UserOrgMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户组织关系 服务
 *
 * @author chenyingjun
 * @version 2017年12月21日
 * @since 1.0
 */
@Service
public class UserOrgService {

    /**
     * 用户组织关系 dao
     */
    @Autowired
    private UserOrgMapper userOrgMapper;
}
