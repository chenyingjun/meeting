package com.chenyingjun.meeting.entity;

import lombok.Data;

import java.util.Date;

/**
 * 会议信息
 */
@Data
public class MtMeeting extends BaseEntity {

    /**
     * 会议名称
     */
    private String meetingName;

    /**
     * 会议状态
     */
    private Integer meetingStatus;

    /**
     * 会议室主键
     */
    private String meetingRoomId;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 更新时间
     */
    private Date updateDate;

    /**
     *参与部门，用英文,号隔开
     */
    private String orgIds;
}