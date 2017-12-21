package com.chenyingjun.meeting.entity;

import lombok.Data;

/**
 * 会与参与者
 */
@Data
public class MeetingUser extends BaseEntity {

    /**
     * 会议主键
     */
    private String meetingId;

    /**
     * 会议参与者主键
     */
    private String userId;

    /**
     * 状态  1.已邀请；2.已签到；3.请假；
     */
    private Integer status;
}