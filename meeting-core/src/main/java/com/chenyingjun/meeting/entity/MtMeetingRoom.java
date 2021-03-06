package com.chenyingjun.meeting.entity;

import lombok.Data;

import java.util.Date;

/**
 * 会议室信息
 */
@Data
public class MtMeetingRoom extends BaseEntity {

    /**
     * 会议室名称
     */
    private String name;

    /**
     * 会议室座位数
     */
    private Integer seatNumber;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 更新时间
     */
    private Date updateDate;
}