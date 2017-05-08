package com.chenyingjun.meeting.entity;

import lombok.Data;

/**
 * 测试用户信息实体
 *
 * @author chenyingjun
 * @version 2017年05月05日
 * @since 1.0
 */
@Data
public class User {
    private long id;

    private String password;

    private String username;
}
