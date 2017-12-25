package com.chenyingjun.meeting.service;

import com.chenyingjun.meeting.entity.MeetingRoom;
import com.chenyingjun.meeting.mapper.MeetingRoomMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 会议室服务
 *
 * @author chenyingjun
 * @version 2017年12月25日
 * @since 1.0
 */
public class MeetingRoomService extends BaseService<MeetingRoom>{

    @Autowired
    private MeetingRoomMapper meetingRoomMapper;

}
