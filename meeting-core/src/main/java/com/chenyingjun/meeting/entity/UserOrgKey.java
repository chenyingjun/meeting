package com.chenyingjun.meeting.entity;

import lombok.Data;

/**
 * 用户组织关系
 */
@Data
public class UserOrgKey{

    /**
     * 用户主键
     */
    private String userId;

    /**
     * 组织主键
     */
    private String orgId;
}