package com.chenyingjun.meeting.dto;

import com.chenyingjun.meeting.validator.NotXss;
import lombok.Data;

import javax.validation.constraints.Pattern;
import java.util.List;

/**
 * 会议列表查询条件
 *
 * @author chenyingjun
 * @version 2017年12月25日
 * @since 1.0
 */
@Data
public class MtMeetingFind {

    /**
     * 会议名称
     */
    @NotXss
    private String meetingName;

    /**
     * 会议状态
     */
    private Integer[] meetingStatus;

    /**
     * 会议室主键
     */
    @NotXss
    private String meetingRoomIds;

    /**
     * 开始时间
     */
    @Pattern(regexp = "([1-2]{1}[0-9]{3})-((1[0-2]{1})|(0[1-9]{1}))-((0[1-9]{1})|([1-2]{1}[0-9]{1})|(3[0-1]{1}))",
            message = "{data.input}")
    private String startTime;

    /**
     * 结束时间
     */
    @Pattern(regexp = "([1-2]{1}[0-9]{3})-((1[0-2]{1})|(0[1-9]{1}))-((0[1-9]{1})|([1-2]{1}[0-9]{1})|(3[0-1]{1}))",
            message = "{data.input}")
    private String endTime;

}
