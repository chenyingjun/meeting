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

    /** 用户主键 */
    private long id;

    /** 用户密码 */
    private String password;

    /** 用户名 */
    private String username;
}
