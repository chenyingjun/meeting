package com.chenyingjun.meeting.entity;

import lombok.Data;

import java.util.Date;

/**
 * 用户信息
 */
@Data
public class User extends BaseEntity {

    /**
     * 姓名
     */
    private String name;

    /**
     * 昵称
     */
    private String username;

    /**
     * 登录名
     */
    private String account;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户名评音
     */
    private String pinyin;

    /**
     * 用户名评音简写
     */
    private String pinyinSim;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 更新时间
     */
    private Date updateDate;

}