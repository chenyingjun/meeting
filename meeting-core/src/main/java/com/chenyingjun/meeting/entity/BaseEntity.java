package com.chenyingjun.meeting.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 基础信息
 *
 * @author chenyingjun
 * @version 2017年05月05日
 * @since 1.0
 */
@Data
public class BaseEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
}
