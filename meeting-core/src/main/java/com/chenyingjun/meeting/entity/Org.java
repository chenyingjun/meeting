package com.chenyingjun.meeting.entity;

import lombok.Data;

import java.util.Date;
/**
 * 组织信息
 */
@Data
public class Org extends BaseEntity {

    /**
     *  组织名称
     */
    private String name;

    /**
     * 组织全名
     */
    private String fullName;

    /**
     * 父主键
     */
    private String parentId;

    /**
     * 父主健集
     */
    private String parentIds;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 更新时间
     */
    private Date updateDate;

    /**
     * 状态   0.禁用；1.可用
     */
    private Integer status;

}