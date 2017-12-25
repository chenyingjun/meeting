package com.chenyingjun.meeting.dto;

import lombok.Data;

/**
 * 会议室列表查询条件
 *
 * @author chenyingjun
 * @version 2017年12月25日
 * @since 1.0
 */
@Data
public class MeetingRoomFind {

    /**
     * 会议室名称
     */
    private String name;

    /**
     * 最小座位数
     */
    private Integer minSeatNumber;

    /**
     * 最大座位数
     */
    private Integer maxSeatNumber;
}
