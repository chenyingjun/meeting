package com.chenyingjun.meeting.vo;

import com.chenyingjun.meeting.entity.MtMeeting;
import lombok.Data;

/**
 * 会议分页 VO
 */
@Data
public class MtMeetingPageVo extends MtMeeting{

    /**
     * 会议室名称
     */
    private String meetingRoomName;
}
